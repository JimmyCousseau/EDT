import discord
from dotenv import load_dotenv
import os
import urllib.request
import re
import time

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
        self.B = 0
        self.E = 0
        for y in self.ade:
            url = y + self.jours
            req = urllib.request.Request(url, headers={'User-Agent': "Magic Browser"})
            rep = urllib.request.urlopen(req)
            bytes_html = rep.read()
            html = bytes_html.decode("ISO-8859-1")
            heures = re.findall(r"(\d+h\d*)", html)
            i = 0
            numerExpr = r"(\d+)"
            days = re.findall(r"([A-Z]+[a-z]\s)", html)
            day = list(set(days))
            nombre_heures = days.count(day[0])
            
            for heure in heures:
                version = int(re.search(numerExpr, heure)[1])
                if (i == 0 or i % 2 == 0):
                    self.B_list.append(version)
                else:
                    self.E_list.append(version)
                i = i + 1
                
        for i in range(nombre_heures - 1):
            if days[i] == day[int(self.jours) - 1]:
                if int(self.B_list[i]) >= 13 and self.B == 0:
                    self.B = int(self.B_list[i])
                if int(self.E_list[i]) <= 12:
                    self.E = int(self.E_list[i])
        
    def predictions(self):
        if self.LieuEtude == "Arsenal" and self.LieuVie == "Bouloie":
            if self.E == 12 and self.B == 13:
                return str(self.name) + "ne va pas manger au ru"
            elif 11 <= self.E and self.B == 13 or 12 == self.E and self.B <= 15:
                return str(self.name) + "  peut manger au ru s'il le veut (mais c'est chiant)"
            elif 11 <= self.E and self.B <= 15:
                return str(self.name) + " va (peut-être) manger au ru"
            else:
                return str(self.name) + " va manger au ru"
        else:
            if self.E == 12 and self.B == 13:
                return str(self.name) + " va manger au ru"
            elif 11 <= self.E and self.B == 13 or 12 == self.E and self.B <= 15:
                return str(self.name) + " va (peut-être) manger au ru"
            elif 11 <= self.E and self.B <= 15:
                return str(self.name) + " peut manger au ru s'il le veut (mais c'est chiant)"
            else :
                return str(self.name) + " ne va pas manger au ru"

            

days = ["1", "2", "3", "4", "5", "6", "7"]
periode = ["Aujourd'hui", "Demain"]


Personnes = [
    ["Jimmy", "Bouloie", "Bouloie", "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=16772&jours="],
    ["Paul",  "Bouloie", "Bouloie",
        "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=16759&jours="],
    ["Clara et Romain",  "Bouloie", "Bouloie",
        "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=16799&jours="],
    ["Antoitoine",  "Bouloie", "Bouloie",
        "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=19298&jours="],
    ["Pierre", "Arsenal", "Bouloie",
        "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=4728&jours=", "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=14555&jours=", "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=2054&jours=", 
        "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=14584&jours=", "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=2048&jours=", "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=10165&jours=", 
        "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=2051&jours=", "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=14670&jours=",]
    ]

for i in range(len(Personnes) - 1):
    Personnes[i] = Request(days[0], Personnes[i][0],
                           Personnes[i][1], Personnes[i][2], Personnes[i][3])
Personnes[4] = Request(days[2], Personnes[4][0], Personnes[4]
                       [1], Personnes[4][2], Personnes[4][3], Personnes[4][4])


for j in range(len(periode)):
    print()
    print("Pour " + periode[j])
    for i in range(len(Personnes)):
        Personnes[i].jours = days[j]
        Personnes[i].get_scheduled()
        print(Personnes[i].predictions())

        
load_dotenv()
TOKEN = os.getenv('DISCORD_TOKEN')
GUILD = os.getenv('DISCORD_GUILD')

client = discord.Client()


@client.event
async def on_ready():
    for guild in client.guilds:
        if guild.name == GUILD:
            break

    print(
        f'{client.user} is connected to the following guild:\n'
        f'{guild.name}(id: {guild.id})'
    )

@client.event
async def on_message(message):
    startTimer = time.time() + 1800
    if 'alone' in message.content.lower() and time.time() > startTimer + 1800:
        for j in range(len(periode)):
            await message.channel.send('--------------------------------------------------------------------')
            await message.channel.send('Pour ' + periode[j])
            for i in range(len(Personnes)):
                Personnes[i].jours = str(j + 1)
                Personnes[i].get_scheduled()
                await message.channel.send(Personnes[i].predictions())

client.run(TOKEN)
