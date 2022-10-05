
import os
import urllib.request
import re
import time
from datetime import date, timedelta
today = date.today()


class Request:
    def __init__(self, jours, name, LieuEtude="Bouloie", LieuVie="Bouloie", *ade):
        self.name = name
        self.jours = jours
        self.ade = ade
        self.LieuVie = LieuVie
        self.LieuEtude = LieuEtude

    def get_scheduled(self):
        self.B_list = []
        self.E_list = []
        self.B = 24
        self.E = 0
        nb_horaires = 0
        day = []
        for y in self.ade:
            url = y + self.jours
            req = urllib.request.Request(
                url, headers={'User-Agent': "Magic Browser"})
            rep = urllib.request.urlopen(req)
            bytes_html = rep.read()
            html = bytes_html.decode("ISO-8859-1")
            heures = re.findall(r"(\d+h\d*)", html)
            i = 0
            numerExpr = r"(\d+)"
            day.extend(re.findall(r"(\s\d{1,2}\s)", html))
            nb_horaires = day.count(
                " " + today + " ")
            for heure in heures:
                version = int(re.search(numerExpr, heure)[1])
                if (i == 0 or i % 2 == 0):
                    if (version in self.B_list):
                        i = i + 2
                    else:
                        self.B_list.append(version)
                elif (version not in self.E_list):
                    self.E_list.append(version)
                i = i + 1

        for i in range(nb_horaires):
            if day[i] == " " + today + " ":
                if self.B_list[i] >= 12 and self.B >= self.B_list[i]:
                    self.B = self.B_list[i]
                if self.E_list[i] <= 12:
                    self.E = self.E_list[i]

    def predictions(self):
        if self.LieuEtude == "Arsenal" and self.LieuVie == "Bouloie":
            if self.E == 12 and self.B == 13:
                return str(self.name) + " ne va pas manger au ru"
            elif ((self.B == 13) or (12 == self.E)):
                return str(self.name) + " peut manger au ru mais il est méga faignant bruuuuuu"
            elif 11 <= self.E and self.B <= 15:
                return str(self.name) + " va (peut-être) manger au ru"
            else:
                return str(self.name) + " va manger au ru"
        else:
            if self.E == 12 and self.B == 13:
                return str(self.name) + " va manger au ru"
            elif (11 <= self.E and self.B == 13) or (12 == self.E and (self.B <= 15 or self.B == 0)):
                return str(self.name) + " va (peut-être) manger au ru"
            elif 11 <= self.E and self.B <= 15:
                return str(self.name) + " peut manger au ru s'il le veut (mais c'est chiant)"
            else:
                return str(self.name) + " ne va pas manger au ru"


days = ["1", "2", "3", "4", "5", "6", "7"]
periode = ["Aujourd'hui", "Demain"]


Personnes = [
    ["Gymie", "Bouloie", "Bouloie",
        "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=16772&jours="],
    ["Pôleux",  "Bouloie", "Bouloie",
        "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=16759&jours="],
    ["Qu'larrah et Rhômm1",  "Bouloie", "Bouloie",
        "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=16799&jours="],
    ["Han! twatouannnnee",  "Bouloie", "Bouloie",
        "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=19298&jours="],
    ["Kayoux", "Arsenal", "Bouloie",
        "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=4728&jours=", "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=14555&jours=", "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=2054&jours=",
        "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=14584&jours=", "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=2048&jours=", "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=10165&jours=",
        "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=2051&jours=", "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=14670&jours=", ]
]

for i in range(len(Personnes) - 1):
    Personnes[i] = Request(days[0], Personnes[i][0],
                           Personnes[i][1], Personnes[i][2], Personnes[i][3])
Personnes[4] = Request(days[2], Personnes[4][0], Personnes[4]
                       [1], Personnes[4][2], Personnes[4][3], Personnes[4][4], Personnes[4][5], Personnes[4][6], Personnes[4][7], Personnes[4][8], Personnes[4][9], Personnes[4][10])


horaire = ""
for j in range(len(periode)):
    today = date.today() + timedelta(days=j)
    todayJ = today.strftime("%A")
    if (today.strftime("%d")[0] == "0"):
        today = today.strftime("%d")[1:]
    else:
        today = today.strftime("%d")
    print("Pour " + todayJ + " " + today)
    horaire += "--------------------------------------------------------\n"
    horaire += "Pour " + todayJ + " " + today + "\n"
    for i in range(len(Personnes)):
        Personnes[i].jours = days[j]
        Personnes[i].get_scheduled()
        print(Personnes[i].predictions())
        horaire += Personnes[i].predictions() + "\n"
    print(Personnes[4].B)
    print(Personnes[4].E)


"""        
load_dotenv()
TOKEN = os.getenv('DISCORD_TOKEN')
GUILD = os.getenv('DISCORD_GUILD')

client = discord.Client()


@client.event
async def on_ready():
    global horaire
    for guild in client.guilds:
        if guild.name == GUILD:
            channel_horaire = client.get_channel(954627832007495720)
            await channel_horaire.send("Bonjour, voici les prévisions du jour :")
            
            await channel_horaire.send(horaire)
            print(
                f'{client.user} is connected to the following guild:\n'
                f'{guild.name}(id: {guild.id})'
            )
            raise SystemExit("Le travaille a été fait")
            break


startTimer = time.time() - 600

@client.event
async def on_message(message):
    global startTimer, periode, today
    if 'alone' in message.content.lower() and startTimer + 600 < time.time():
        startTimer = time.time()
        for j in range(len(periode)):
            today = date.today() + timedelta(days=j)
            horaire = ""
            horaire += "--------------------------------------------------------\n"
            horaire += "Pour " + today.strftime("%A") + " " + today.strftime("%d") + "\n"
            for i in range(len(Personnes)):
                Personnes[i].jours = days[j]
                Personnes[i].get_scheduled()
                horaire += Personnes[i].predictions() + "\n"
            await message.channel.send(horaire)
            
client.run(TOKEN) """
