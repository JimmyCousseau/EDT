import discord
from dotenv import load_dotenv
import os
import urllib.request
import re
import time
from datetime import date, timedelta
today = date.today()

""" Crée une classe pour pouvoir récupérer les données, les extraires et les traiters pour ensuite les displays sur la console """
class Request:
    def __init__(self, jours, name, LieuEtude="Bouloie", LieuVie="Bouloie", *ade):
        self.name = name
        self.jours = jours
        self.ade = ade
        """ Pour prendre en compte la distance lors de la prédiction """
        self.LieuVie = LieuVie
        self.LieuEtude = LieuEtude
        
    def get_scheduled(self):
        self.B_list = [] """ Enregistre l'heure de début de tout les cours """
        self.E_list = [] """ Enregistre l'heure de fin de tout les cours """
        """ Sélectionne l'horaire le plus proche de midi """
        self.B = 24 
        self.E = 0
        nb_horaires = 0 """ compte le nombre d'horaire dans la journée, sert pour le traitement de la donnée """
        day = []
        for y in self.ade:
            """ Récupère toutes les heures sous le format " 10 " qui correspond à l'heure """
            url = y + self.jours
            req = urllib.request.Request(url, headers={'User-Agent': "Magic Browser"})
            rep = urllib.request.urlopen(req)
            bytes_html = rep.read()
            html = bytes_html.decode("ISO-8859-1")
            heures = re.findall(r"(\d+h\d*)", html)
            """"""""""""""""""""""""""""""""""""""""""""""""""""""
            """ Récupère le jour pour enlever les données qu'on ne veut pas """
            i = 0
            numerExpr = r"(\d+)"
            day.extend(re.findall(r"(\s\d{1,2}\s)", html))
            nb_horaires = day.count(
                " " + today + " ")
            """"""""""""""""""""""""""""""""""""""""""""""""""""""
            """ for : trie les données dans les tableaux """
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
                
        """ for : sélectionne l'horaire le plus proche de midi """
        for i in range(nb_horaires):
            if day[i] == " " + today + " ":
                if self.B_list[i] >= 12 and self.B >= self.B_list[i]:
                    self.B = self.B_list[i]
                if self.E_list[i] <= 12:
                    self.E = self.E_list[i]
        """ predictions : fais la prédiction en fonction du lieu de vie et d'étude """
    def predictions(self):
        if self.LieuEtude == "Arsenal" and self.LieuVie == "Bouloie":
            if self.E == 12 and self.B == 13:
                return str(self.name) + " ne va pas manger au ru"
            elif (11 <= self.E and self.B == 13) or (12 == self.E and self.B <= 15):
                return str(self.name) + " peut manger au ru s'il le veut (mais c'est chiant)"
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
            else :
                return str(self.name) + " ne va pas manger au ru"



Personnes = [
    ["Gérard Menvussa", "Bouloie", "Bouloie", "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=......&jours="],
    ["Lara Masse",  "Arsenal", "Bouloie",
        "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=......&jours=", "https://sedna.univ-fcomte.fr/jsp/custom/ufc/mplanif.jsp?id=......&jours="]
    ]


""" Initialise les "objets" """
for i in range(len(Personnes) - 1):
    Personnes[i] = Request(1, Personnes[i][0],
                           Personnes[i][1], Personnes[i][2], Personnes[i][3])
Personnes[1] = Request(1, Personnes[4][0], Personnes[4]
                       [1], Personnes[4][2], Personnes[4][3], Personnes[4][4])


""" Affiche les prédictions """
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


""" À partir d'ici tout est pour envoyer sur discord """
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
            
client.run(TOKEN)
