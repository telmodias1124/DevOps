package data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class TeamData {
	private Random r;
	private LinkedList<String> ll;
	private LinkedList<Player> llPlayer;
	private Team t;
	
	
	public TeamData() {
		r = new Random();
		ll  = new LinkedList <String>();
		llPlayer = new LinkedList<Player>();
	}
	
	public void createTeams(ArrayList<Team> alTeams) {
		ll.add("France");
        ll.add("Germany");
        ll.add("Belgium");
        ll.add("Peru");
        ll.add("Mexico");
        ll.add("Brazil");
        ll.add("Poland");
        ll.add("Switzerland");
        ll.add("Uruguay");
        ll.add("Portugal");
        ll.add("England");
        ll.add("Croatia");
        ll.add("Argentina");
        ll.add("Spain");
        ll.add("Colombia");
        ll.add("Denmark");
		
		//FRANCE

		llPlayer.add(ClassFactory.creatPlayer("Hugo","Lloris",new PlayerStatistic(82,62,68,89,91,84,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Steve","Mandanda",new PlayerStatistic(79,43,74,80,81,79,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Alphonse","Areola",new PlayerStatistic(79,54,80,85,84,78,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Benjamin","Pavard",new PlayerStatistic(47,81,72,69,70,74,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Presnel","Kimpembe",new PlayerStatistic(39,81,67,75,68,83,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Raphäel","Varane",new PlayerStatistic(45,85,62,83,64,80,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Samuel","Umtiti",new PlayerStatistic(63,86,69,69,70,82,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Adil","Rami",new PlayerStatistic(48,76,53,47,60,81,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Djibril","Sidibé",new PlayerStatistic(62,73,74,77,74,79,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Lucas","Hernandez",new PlayerStatistic(54,83,70,81,71,82,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Benjamin","Mendy",new PlayerStatistic(51,77,77,81,77,77,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Paul","Pogba",new PlayerStatistic(81,66,86,74,85,86,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Corentin","Tolisso",new PlayerStatistic(77,76,79,69,78,79,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("N’Golo","Kanté",new PlayerStatistic(65,87,77,78,81,83,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Blaise","Matudi",new PlayerStatistic(66,83,76,75,78,81,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Steven","Nzonzi",new PlayerStatistic(55,79,71,42,69,86,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Antoine","Griezmann",new PlayerStatistic(86,57,84,81,89,72,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Thomas","Lemar",new PlayerStatistic(76,59,82,83,85,67,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Olivier","Giroud",new PlayerStatistic(81,42,71,46,73,79,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Kylian","Mbappé",new PlayerStatistic(84,39,78,96,90,75,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Ousmane","Dembélé",new PlayerStatistic(79,36,80,93,87,57,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Nabil","Fekir",new PlayerStatistic(82,33,81,78,88,77,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Florian","Thauvin",new PlayerStatistic(80,41,81,83,83,69,r.nextInt(50)+50),"A"));


		//ALLEMAGNE


		llPlayer.add(ClassFactory.creatPlayer("Manuel","Neuer",new PlayerStatistic(87,60,91,87,87,85,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Marc-André","Ter Stegen",new PlayerStatistic(85,43,88,88,90,88,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Kevin","Trapp",new PlayerStatistic(77,52,79,82,85,83,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Jérôme","Boateng",new PlayerStatistic(50,84,72,66,66,82,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Matthias","Ginter",new PlayerStatistic(58,82,69,62,65,77,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Jonas","Hector",new PlayerStatistic(60,78,75,75,75,75,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Joshua","Kimmich",new PlayerStatistic(69,79,86,72,84,78,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Mats","Hummels",new PlayerStatistic(58,89,76,51,73,76,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Marvin","Plattenhardt",new PlayerStatistic(55,74,77,71,75,72,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Antonio","Rüdiger",new PlayerStatistic(43,82,67,72,64,78,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Niklas","Süle",new PlayerStatistic(42,86,55,72,51,82,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Julian","Brandt",new PlayerStatistic(78,40,81,82,85,68,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Julian","Draxler",new PlayerStatistic(79,55,81,77,86,63,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Marco","Reus",new PlayerStatistic(88,45,84,85,87,66,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Leon","Goretzka",new PlayerStatistic(77,75,80,81,81,79,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Ilkay","Gündogan",new PlayerStatistic(74,72,84,66,84,71,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Sami","Khedira",new PlayerStatistic(74,80,78,51,78,80,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Toni","Kroos",new PlayerStatistic(80,70,90,45,81,69,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Thomas","Müller",new PlayerStatistic(83,55,79,72,78,71,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Mesut","Ozil",new PlayerStatistic(72,24,86,70,84,56,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Sebastian","Rudy",new PlayerStatistic(67,75,79,64,78,67,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Mario","Gomez",new PlayerStatistic(75,35,59,58,67,75,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Timo","Werner",new PlayerStatistic(81,35,67,92,82,69,r.nextInt(50)+50),"A"));

		//BELGIQUE

		llPlayer.add(ClassFactory.creatPlayer("Thibault","Courtois",new PlayerStatistic(89,43,72,85,87,85,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Simon","Mignolet",new PlayerStatistic(72,52,62,79,80,75,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Koen","Casteels",new PlayerStatistic(79,46,79,83,82,82,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Toby","Alderweireld",new PlayerStatistic(55,88,72,64,67,79,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Thomas","Vemaelen",new PlayerStatistic(61,77,70,64,61,69,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Vincent","Kompany",new PlayerStatistic(53,84,65,50,64,79,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Jan","Vertonghen",new PlayerStatistic(63,87,74,63,73,79,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Thomas","Meunier",new PlayerStatistic(75,68,77,79,75,84,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Dedryck","Boyata",new PlayerStatistic(30,74,51,64,60,85,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Axel","Wistel",new PlayerStatistic(74,83,80,73,80,81,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Kevin","De Bruyne",new PlayerStatistic(86,61,92,67,87,78,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Marouane","Fellaini",new PlayerStatistic(71,76,70,42,69,88,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Yannick","Carrasco",new PlayerStatistic(80,39,75,90,86,64,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Dries","Mertens",new PlayerStatistic(83,35,80,88,90,53,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Thorgan","Hazard",new PlayerStatistic(77,47,80,82,85,64,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Youri","Tielemans",new PlayerStatistic(78,68,82,63,78,67,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Adnan","Januzaj",new PlayerStatistic(76,29,74,76,82,56,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Mousa","Dembélé",new PlayerStatistic(68,77,77,73,87,80,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Nacer","Chadli",new PlayerStatistic(73,47,74,71,76,75,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Leander","Dendoncker",new PlayerStatistic(72,78,77,67,71,83,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Romelu","Lukaku",new PlayerStatistic(82,35,73,75,72,84,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Eden","Hazard",new PlayerStatistic(83,35,86,91,94,66,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Michy","Batshuayi",new PlayerStatistic(79,33,58,76,78,72,r.nextInt(50)+50),"A"));

		//PEROU

		llPlayer.add(ClassFactory.creatPlayer("Pedro","Gallese",new PlayerStatistic(80,45,75,85,70,85,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Carlos","Caceda",new PlayerStatistic(84,40,74,86,75,86,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("José","Carvallo",new PlayerStatistic(85,45,76,73,80,64,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Alberto","Rodriguez",new PlayerStatistic(59,68,67,64,70,75,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Aldo","Corzo",new PlayerStatistic(63,73,61,63,70,74,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Anderson","Santamaria",new PlayerStatistic(61,70,64,65,64,69,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Miguel","Trauco",new PlayerStatistic(49,71,73,68,74,79,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Miguel","Araujo",new PlayerStatistic(50,74,70,62,72,77,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Christian","Ramos",new PlayerStatistic(52,72,70,60,71,67,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Luis","Advincula",new PlayerStatistic(64,66,70,94,75,76,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Nilson","Loyola",new PlayerStatistic(67,56,72,91,70,77,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Paolo","Hurtado",new PlayerStatistic(71,44,71,81,75,59,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Christian","Cueva",new PlayerStatistic(57,63,63,81,68,61,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Renato","Tapia",new PlayerStatistic(56,72,67,70,74,79,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Andy","Polo",new PlayerStatistic(58,56,59,89,67,53,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Wilder","Cartagena",new PlayerStatistic(57,59,50,80,70,54,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Yoshimar","Yotun",new PlayerStatistic(63,64,76,65,74,71,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Edison","Flores",new PlayerStatistic(63,37,65,76,74,57,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Pedro","Aquino",new PlayerStatistic(59,70,67,77,68,73,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Paolo","Guerrero",new PlayerStatistic(62,71,64,77,72,74,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Jefferson","Farfan",new PlayerStatistic(73,36,75,84,76,75,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Raul","Ruidiaz",new PlayerStatistic(77,32,64,80,76,61,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("André","Carrillo",new PlayerStatistic(74,34,72,86,82,67,r.nextInt(50)+50),"A"));

		//MEXIQUE

		llPlayer.add(ClassFactory.creatPlayer("José","de Jesus Corona",new PlayerStatistic(77,38,68,72,73,78,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Alfredo","Talavera",new PlayerStatistic(70,58,70,79,77,70,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Guillermo","Ochoa",new PlayerStatistic(70,58,70,79,77,70,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Hugo","Ayala",new PlayerStatistic(55,76,60,57,58,72,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Carlos","Salcedo",new PlayerStatistic(31,77,52,65,63,78,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Erick","Gutérrez",new PlayerStatistic(71,64,74,75,74,66,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Miguel","Layun",new PlayerStatistic(72,75,75,76,75,69,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Héctor","Moreno",new PlayerStatistic(50,73,85,75,73,68,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Edson","Alvarez",new PlayerStatistic(53,75,66,70,68,75,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Jesus","Gallardo",new PlayerStatistic(67,66,69,78,73,71,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Rafael","Marquez",new PlayerStatistic(68,70,63,78,71,65,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Jonathan","Dos Santos",new PlayerStatistic(67,68,78,72,78,70,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Marco","Fabian",new PlayerStatistic(75,34,75,63,78,63,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Giovani","Dos Santos",new PlayerStatistic(73,33,73,84,79,51,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Hector","Herrera",new PlayerStatistic(75,78,75,72,76,81,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Andrés","Guardado",new PlayerStatistic(68,72,81,68,82,68,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Javier","Aquino",new PlayerStatistic(66,40,70,88,79,51,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Raul","Jiménez",new PlayerStatistic(86,53,80,85,83,85,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Carlos","Vela",new PlayerStatistic(82,31,78,80,84,67,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Javier","Hernandez",new PlayerStatistic(77,31,64,70,75,59,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Jesus","Manuel Corona",new PlayerStatistic(78,67,81,88,92,61,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Oribe","Peralta",new PlayerStatistic(72,41,66,68,72,74,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Hirving","Lozano",new PlayerStatistic(76,41,73,93,83,66,r.nextInt(50)+50),"A"));

		//BRESIL

		llPlayer.add(ClassFactory.creatPlayer("Alisson","Becker",new PlayerStatistic(84,52,85,85,89,90,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Cassio","Ramos",new PlayerStatistic(74,40,68,76,75,73,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Ederson","De Moraes",new PlayerStatistic(82,64,93,86,88,86,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Thiago","Silva",new PlayerStatistic(57,90,77,66,76,81,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Miranda","De Souza",new PlayerStatistic(49,84,60,64,68,74,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Pedro","Geromel",new PlayerStatistic(74,43,57,69,71,65,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Filipe","Luis",new PlayerStatistic(78,38,71,69,64,62,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Marcelo","Silva Junior",new PlayerStatistic(74,77,83,81,89,79,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Marcos","Aoas Correa",new PlayerStatistic(41,86,73,74,71,77,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Danilo","Da Silva",new PlayerStatistic(70,78,74,71,74,76,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Fagner","Lemos",new PlayerStatistic(45,68,48,65,55,77,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Carlos","Henrique",new PlayerStatistic(72,85,75,62,72,89,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Renato","Augusto",new PlayerStatistic(73,71,79,67,79,72,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Philippe","Coutinho",new PlayerStatistic(80,52,84,79,90,64,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("José","Paulo",new PlayerStatistic(81,78,77,72,80,85,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Fernando","Luiz Roza",new PlayerStatistic(74,84,79,66,79,79,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Frederico","Rodrigues",new PlayerStatistic(73,74,75,76,80,69,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Willian","Da Silva",new PlayerStatistic(71,31,46,36,56,75,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Douglas","Costa",new PlayerStatistic(73,43,79,91,43,61,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Gabriel","Jesus",new PlayerStatistic(80,39,72,85,86,71,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Neymar","Da Silva",new PlayerStatistic(85,32,87,91,95,58,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Roberto","Firmino",new PlayerStatistic(82,61,80,77,87,78,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Taison","Barcellos",new PlayerStatistic(79,47,75,92,86,69,r.nextInt(50)+50),"A"));



		//POLOGNE

		llPlayer.add(ClassFactory.creatPlayer("Wojciech","Szczesny",new PlayerStatistic(82,47,73,85,88,86,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Bartosz","Bialkowski",new PlayerStatistic(70,42,65,65,71,73,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Lukasz","Fibianski",new PlayerStatistic(65,47,68,67,70,69,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Michal","Pazdan",new PlayerStatistic(44,70,59,48,57,72,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Artur","Jedrzejczyk",new PlayerStatistic(48,68,60,67,64,80,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Thiago","Rangel",new PlayerStatistic(26,72,44,63,53,74,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Jan","Bednarek",new PlayerStatistic(22,78,52,62,56,74,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Kamil","Glik",new PlayerStatistic(32,79,44,45,54,82,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Bartosz","Bereszynski",new PlayerStatistic(56,70,65,85,70,72,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Lukasz","Piszczek",new PlayerStatistic(68,82,75,77,73,78,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Jackek","Goralski",new PlayerStatistic(61,70,75,64,74,70,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Karol","Linetty",new PlayerStatistic(63,72,71,69,75,70,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Grzegorz","Krychowiak",new PlayerStatistic(57,75,71,65,69,80,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Kamil","Grosicki",new PlayerStatistic(72,38,71,83,74,60,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Maciej","Rybus",new PlayerStatistic(69,70,72,77,72,67,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Jakub","Blaszczykowski",new PlayerStatistic(70,60,75,72,77,67,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Slawomir","Peszko",new PlayerStatistic(61,36,64,76,64,61,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Piotr","Zielinski",new PlayerStatistic(72,70,81,81,83,61,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Rafal","Kurzawa",new PlayerStatistic(65,61,72,57,71,57,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Arkadiusz","Milik",new PlayerStatistic(85,39,64,69,76,74,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Robert","Lewandowski",new PlayerStatistic(87,41,74,77,85,82,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Lukasz","Teodorcyk",new PlayerStatistic(74,33,60,63,66,77,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Dawid","Kownacki",new PlayerStatistic(70,28,59,78,70,70,r.nextInt(50)+50),"A"));

		//SUISSE

		llPlayer.add(ClassFactory.creatPlayer("Yann","Sommer",new PlayerStatistic(85,54,81,79,87,80,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Yvon","Mvogo",new PlayerStatistic(74,41,71,80,79,71,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Roman","Burki",new PlayerStatistic(80,54,73,86,89,83,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Stephan","Lichtsteiner",new PlayerStatistic(58,75,70,60,73,72,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Francois","Moubandje",new PlayerStatistic(48,71,65,67,69,76,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Nico","Elvedi",new PlayerStatistic(34,78,62,71,69,75,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Manuel","Akanji",new PlayerStatistic(45,83,68,78,72,80,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Michael","Lang",new PlayerStatistic(69,76,68,68,66,78,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Ricardo","Rodriguez",new PlayerStatistic(67,78,79,70,76,74,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Johan","Djourou",new PlayerStatistic(61,79,76,63,67,71,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Fabian","Schar",new PlayerStatistic(66,80,71,62,69,75,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Remo","Freuler",new PlayerStatistic(69,70,75,66,75,69,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Granit","Xhaka",new PlayerStatistic(67,69,81,51,71,78,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Valon","Behrami",new PlayerStatistic(64,74,71,62,71,74,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Steven","Zuber",new PlayerStatistic(74,71,73,78,77,75,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Blerim","Dzemaili",new PlayerStatistic(73,71,76,57,76,66,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Gelson","Fernandes",new PlayerStatistic(56,77,68,57,66,80,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Denis","Zakaria",new PlayerStatistic(63,79,74,84,77,84,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Xherdan","Shaqiri",new PlayerStatistic(77,46,81,80,85,69,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Breel","Embolo",new PlayerStatistic(71,39,67,75,75,75,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Haris","Seferovic",new PlayerStatistic(77,67,67,71,72,86,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Mario","Gavranovic",new PlayerStatistic(70,37,62,74,74,65,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Josip","Drmic",new PlayerStatistic(75,38,67,76,73,70,r.nextInt(50)+50),"A"));

		//URUGUAY

		llPlayer.add(ClassFactory.creatPlayer("Fernando","Muslera",new PlayerStatistic(75,62,75,81,83,81,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Martin","Campana",new PlayerStatistic(75,48,78,79,80,79,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Martin","Silva",new PlayerStatistic(73,49,80,80,74,75,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("José","Giménez",new PlayerStatistic(45,86,52,69,56,82,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Diego","Godin",new PlayerStatistic(48,89,64,60,63,83,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Guillermo","Varela",new PlayerStatistic(34,67,56,77,67,71,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Gaston","Silva",new PlayerStatistic(53,73,68,67,66,72,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Maxi","Pereira",new PlayerStatistic(60,74,61,66,70,76,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Sebastian","Coates",new PlayerStatistic(43,83,55,54,60,85,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Martin","Caceres",new PlayerStatistic(51,79,65,74,70,73,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Carlos","Sanchez",new PlayerStatistic(58,74,70,60,68,73,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Rodrigo","Bentacur",new PlayerStatistic(58,70,78,70,81,74,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Cristian","Rodriguez",new PlayerStatistic(60,82,70,60,68,74,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Nahitan","Nandez",new PlayerStatistic(69,84,72,84,80,88,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Giorgian","De Arrascaeta",new PlayerStatistic(70,80,69,72,82,74,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Lucas","Torreira",new PlayerStatistic(67,81,77,75,80,75,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Matias","Vecino",new PlayerStatistic(68,76,77,67,80,74,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Diego","Laxalt",new PlayerStatistic(63,62,74,88,78,69,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Luis","Suarez",new PlayerStatistic(89,51,80,73,84,84,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Cristhian","Stuani",new PlayerStatistic(78,48,69,69,75,82,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Maxi","Gomez",new PlayerStatistic(80,32,68,64,73,79,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Jonathan","Urretaviscaya",new PlayerStatistic(70,34,72,77,74,61,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Edinson","Cavani",new PlayerStatistic(86,55,72,75,79,83,r.nextInt(50)+50),"A"));

		//PORTUGAL

		llPlayer.add(ClassFactory.creatPlayer("Rui","Patricio",new PlayerStatistic(80,57,77,84,82,81,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Anthony","Lopes",new PlayerStatistic(75,30,76,79,83,57,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Antonio","Alberto",new PlayerStatistic(64,39,70,74,80,56,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Bruno","Alves",new PlayerStatistic(67,71,64,37,64,81,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Képler","Laveran",new PlayerStatistic(51,85,57,67,61,85,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Raphael","Guerreiro",new PlayerStatistic(75,66,82,73,85,57,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("José","Fonte",new PlayerStatistic(38,81,54,36,61,76,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Ruben","Dias",new PlayerStatistic(38,81,50,64,60,83,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Ricardo","Pereira",new PlayerStatistic(70,86,83,91,86,79,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Mario","Rui",new PlayerStatistic(49,73,73,83,79,67,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Cédric","Soares",new PlayerStatistic(66,73,70,77,75,70,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Manuel","Fernandes",new PlayerStatistic(56,69,66,67,67,65,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Joao","Moutinho",new PlayerStatistic(75,71,85,56,82,67,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Joao","Mario",new PlayerStatistic(69,64,80,69,83,67,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Bernando","Silva",new PlayerStatistic(77,52,84,82,93,68,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("William","Carvalho",new PlayerStatistic(57,79,77,42,74,85,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Bruno","Fernandes",new PlayerStatistic(83,65,87,77,85,74,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Adrien","Silva",new PlayerStatistic(74,70,79,58,76,65,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Cristiano","Ronaldo",new PlayerStatistic(93,35,82,90,89,78,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("André","Silva",new PlayerStatistic(75,43,63,77,78,75,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Goncalo","Guedes",new PlayerStatistic(79,36,76,90,83,70,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Gelson","Martins",new PlayerStatistic(71,47,74,95,86,61,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Ricardo","Quaresma",new PlayerStatistic(73,24,82,77,86,63,r.nextInt(50)+50),"A"));

		//ANGLETERRE

		llPlayer.add(ClassFactory.creatPlayer("Jordan","Pickford",new PlayerStatistic(78,44,87,82,86,82,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Jack","Bultand",new PlayerStatistic(75,43,58,75,80,82,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Nick","Pope",new PlayerStatistic(80,47,75,78,79,80,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Kyle","Walker",new PlayerStatistic(63,81,76,91,77,81,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Danny","Rose",new PlayerStatistic(62,80,74,77,79,75,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("John","Stones",new PlayerStatistic(36,84,70,68,72,77,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Harry","Maguire",new PlayerStatistic(53,81,64,50,70,84,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Kieran","Trippier",new PlayerStatistic(60,78,81,74,76,72,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Gary","Cahill",new PlayerStatistic(58,78,51,41,57,74,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Phil","Jones",new PlayerStatistic(51,78,61,55,58,76,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Trent","Alexander-Arnold",new PlayerStatistic(62,78,82,80,78,70,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Eric","Dier",new PlayerStatistic(63,80,71,54,65,84,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Jesse","Lingard",new PlayerStatistic(78,58,76,80,73,72,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Jordan","Henderson",new PlayerStatistic(70,78,83,64,77,80,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Raheem","Sterling",new PlayerStatistic(79,45,78,93,89,57,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Fabian","Delph",new PlayerStatistic(70,73,76,69,79,74,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Ashley","Young",new PlayerStatistic(66,73,74,70,75,71,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Dele","Alli",new PlayerStatistic(85,73,83,77,86,82,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Ruben","Loftus-Cheek",new PlayerStatistic(67,62,76,70,80,79,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Harry","Kane",new PlayerStatistic(91,47,79,70,81,83,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Jamie","Vardy",new PlayerStatistic(84,57,67,89,78,76,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Danny","Welbeck",new PlayerStatistic(74,43,70,77,76,74,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Marcus","Rashford",new PlayerStatistic(82,45,73,92,83,77,r.nextInt(50)+50),"A"));

		//CROATIE

		llPlayer.add(ClassFactory.creatPlayer("Dominik","Livakovic",new PlayerStatistic(78,48,74,80,82,79,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Lovre","Kalinic",new PlayerStatistic(74,39,43,80,78,75,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Danjiel","Subasic",new PlayerStatistic(75,54,76,79,81,80,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Sime","Vrsaljko",new PlayerStatistic(55,79,74,77,75,77,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Ivan","Šunjic",new PlayerStatistic(57,77,60,70,64,79,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Vedran","Corluka",new PlayerStatistic(49,81,65,58,68,82,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Dejan","Lovren",new PlayerStatistic(40,80,59,54,63,78,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Tin","Jedvaj",new PlayerStatistic(51,75,58,69,64,75,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Duje","Caeleta-Car",new PlayerStatistic(40,75,59,64,59,79,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Domagoj","Vida",new PlayerStatistic(40,82,59,75,61,79,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Josip","Pivaric",new PlayerStatistic(61,66,69,76,71,63,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Ivan","Rakitic",new PlayerStatistic(81,74,86,62,81,70,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Mateo","Kovacic",new PlayerStatistic(68,67,81,76,86,70,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Luka","Modric",new PlayerStatistic(76,72,89,74,90,66,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Marcelo","Brozovic",new PlayerStatistic(73,76,79,64,80,73,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Filip","Bradaric",new PlayerStatistic(47,63,63,77,71,61,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Milan","Badelj",new PlayerStatistic(63,76,76,54,73,71,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Ivan","Perisic",new PlayerStatistic(80,62,78,84,82,77,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Adrej","Kramaric",new PlayerStatistic(85,30,73,85,65,71,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Nikola","Kalinic",new PlayerStatistic(76,42,64,67,74,72,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Mario","Mandzukic",new PlayerStatistic(80,65,71,68,76,86,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Ante","Rebic",new PlayerStatistic(80,39,70,88,78,81,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Marko","Pjaca",new PlayerStatistic(67,41,74,77,83,67,r.nextInt(50)+50),"A"));

		//ARGENTINE

		llPlayer.add(ClassFactory.creatPlayer("Nahuel","Guzman",new PlayerStatistic(76,52,70,78,79,80,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Franco","Armani",new PlayerStatistic(75,40,70,78,86,81,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Willy","Caballero",new PlayerStatistic(72,46,71,74,74,76,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Gabriel","Mercado",new PlayerStatistic(63,82,64,81,74,80,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Nicolas","Tagliafico",new PlayerStatistic(57,80,72,81,76,81,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Cristian","Ansaldi",new PlayerStatistic(62,76,77,75,79,70,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Federico","Fazio",new PlayerStatistic(41,82,54,33,55,81,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Marcos","Acuna",new PlayerStatistic(74,76,81,76,86,84,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Marcos","Rojo",new PlayerStatistic(59,76,68,67,65,76,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Nicolas","Otamendi",new PlayerStatistic(57,83,63,56,61,78,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Eduardo","Salvio",new PlayerStatistic(75,86,73,86,84,68,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Lucas","Biglia",new PlayerStatistic(63,77,81,55,81,68,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Ever","Banega",new PlayerStatistic(73,77,84,61,82,70,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Angel","Di Maria",new PlayerStatistic(79,48,84,84,87,68,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Maximilianio","Meza",new PlayerStatistic(72,48,74,80,82,71,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Javier","Mascherano",new PlayerStatistic(53,79,72,66,69,75,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Enzo","Perez",new PlayerStatistic(81,86,88,82,85,90,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Giovani","Lo Celso",new PlayerStatistic(78,65,82,77,84,72,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Cristian","Pavon",new PlayerStatistic(76,49,75,91,78,74,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Gonzalo","Higuain",new PlayerStatistic(85,31,71,63,80,71,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Lionel","Messi",new PlayerStatistic(92,39,92,87,96,66,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Sergio","Aguero",new PlayerStatistic(90,33,77,80,88,74,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Paulo","Dybala",new PlayerStatistic(82,43,84,83,90,64,r.nextInt(50)+50),"A"));



		//ESPAGNE

		llPlayer.add(ClassFactory.creatPlayer("David","De Gea",new PlayerStatistic(84,58,81,90,92,85,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Kepa","Arrizabalaga",new PlayerStatistic(82,33,86,84,85,80,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Pepe","Reina",new PlayerStatistic(82,63,82,79,81,82,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Daniel","Carvajal",new PlayerStatistic(47,82,78,81,81,80,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Gerard","Pique",new PlayerStatistic(61,88,72,56,69,80,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("José","Fernandez",new PlayerStatistic(64,70,75,80,63,61,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Alvaro","Odriozola",new PlayerStatistic(53,77,71,89,76,69,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Cesar","Azpilicueta",new PlayerStatistic(55,85,77,70,73,76,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Sergio","Ramos",new PlayerStatistic(68,87,75,72,74,85,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Nacho","Monreal",new PlayerStatistic(61,80,71,63,74,68,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Jordi","Alba",new PlayerStatistic(69,79,81,90,83,73,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Sergio","Busquets",new PlayerStatistic(62,85,80,42,81,80,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Andres","Iniesta",new PlayerStatistic(70,62,86,64,87,60,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Saul","Esclapez",new PlayerStatistic(78,78,79,70,81,78,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Jorge","Merodio",new PlayerStatistic(75,74,86,68,82,79,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Thiago","Alcantara",new PlayerStatistic(74,69,85,69,90,63,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("David","Silva",new PlayerStatistic(74,52,88,65,89,57,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Francisco","Roman",new PlayerStatistic(77,59,83,71,90,60,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Rodrigo","Machado",new PlayerStatistic(80,44,74,90,81,70,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Lucas","Vazquez",new PlayerStatistic(73,58,79,82,81,69,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Iago","Aspas",new PlayerStatistic(84,35,77,78,85,64,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Diego","Costa",new PlayerStatistic(82,49,64,73,76,85,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Marco","Asensio",new PlayerStatistic(80,43,82,81,84,62,r.nextInt(50)+50),"A"));

		//COLOMBIE

		llPlayer.add(ClassFactory.creatPlayer("David","Ospina",new PlayerStatistic(73,34,78,83,85,78,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Camilo","Vargas",new PlayerStatistic(74,48,69,77,81,76,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("José","Fernando Cuadrado",new PlayerStatistic(70,45,72,74,83,73,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Cristian","Zapata",new PlayerStatistic(32,82,46,61,57,76,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Oscar","Murillo",new PlayerStatistic(39,74,55,69,52,77,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Santiago","Arias",new PlayerStatistic(53,76,69,83,75,77,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Yerry","Mina",new PlayerStatistic(54,78,55,51,57,80,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Johan","Mojica",new PlayerStatistic(65,69,72,90,74,72,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Farid","Diaz",new PlayerStatistic(50,69,66,72,70,68,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Davinson","Sanchez",new PlayerStatistic(45,83,57,74,67,81,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Wilmar","Barrios",new PlayerStatistic(63,34,56,50,63,65,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Carlos","Sanchez",new PlayerStatistic(58,74,70,60,68,73,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Abel","Aguilar",new PlayerStatistic(61,74,67,32,64,81,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("James","Rodriguez",new PlayerStatistic(86,50,87,55,86,63,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Juan","Cuadrado",new PlayerStatistic(72,66,77,91,87,67,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Mateus","Uribe",new PlayerStatistic(72,68,72,75,74,79,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Jefferson","Lerma",new PlayerStatistic(64,78,72,73,73,80,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Juan","Fernando Quintero",new PlayerStatistic(77,37,81,73,83,50,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Carlos","Bacca",new PlayerStatistic(76,33,64,70,76,66,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Radalel","Falcao",new PlayerStatistic(82,43,69,65,77,72,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Luis","Muriel",new PlayerStatistic(76,27,68,88,83,68,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Miguel","Borja",new PlayerStatistic(90,41,76,80,88,88,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("José","Izquierdo",new PlayerStatistic(69,38,67,86,80,53,r.nextInt(50)+50),"A"));

		//DANEMARK

		llPlayer.add(ClassFactory.creatPlayer("Kasper","Schmeichel",new PlayerStatistic(77,60,79,82,89,79,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Jonas","Lossl",new PlayerStatistic(76,34,65,74,77,74,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Frederik","Ronnow",new PlayerStatistic(70,45,66,74,77,74,r.nextInt(50)+50),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Jannik","Vestergaard",new PlayerStatistic(49,80,61,34,49,77,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Simon","Kjaer",new PlayerStatistic(55,81,63,65,56,78,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Jonas","Knudsen",new PlayerStatistic(45,67,62,66,64,72,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Andreas","Christensen",new PlayerStatistic(31,82,63,68,69,72,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Mathias","Jorgensen",new PlayerStatistic(40,75,59,66,56,80,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Henrik","Dalsgaard",new PlayerStatistic(58,69,62,76,65,70,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Jens","Stryger Larsen",new PlayerStatistic(55,72,63,76,69,76,r.nextInt(50)+50),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Michael","Krohn-Dehli",new PlayerStatistic(65,73,83,74,64,75,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Wiliam","Kvist",new PlayerStatistic(69,81,76,77,71,69,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Thomas","Delaney",new PlayerStatistic(73,83,74,77,75,82,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Christian","Eriksen",new PlayerStatistic(81,53,90,73,84,63,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Lukas","Lerager",new PlayerStatistic(67,70,69,61,69,74,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Lasse","Schone",new PlayerStatistic(74,63,81,48,76,62,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Pione","Sisto",new PlayerStatistic(75,47,72,80,81,63,r.nextInt(50)+50),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Nicolai","Jorgensen",new PlayerStatistic(76,39,70,71,73,76,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Martin","Braithwaite",new PlayerStatistic(74,35,69,75,76,75,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Kasper","Dolberg",new PlayerStatistic(80,29,61,75,74,65,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Viktor","Fischer",new PlayerStatistic(72,37,73,82,80,70,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Yussuf","Poulsen",new PlayerStatistic(74,56,67,83,75,82,r.nextInt(50)+50),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Andreas","Cornelius",new PlayerStatistic(81,46,61,70,72,84,r.nextInt(50)+50),"A"));

		for(int i=1; i<17; i++) {
			t = new Team(ll.get(i-1));
			for(int j=0; j<23; j++) {
					if(j==0 && i==1) {
						t.getStarter().add(llPlayer.get(0));
						t.getBench().add(llPlayer.get((j*i)+1));
						t.getBench().add(llPlayer.get((j*i)+2));
					}
					else if(j==0) {
						t.getStarter().add(llPlayer.get((23*(i-1))));
						t.getBench().add(llPlayer.get((23*(i-1))+1));
						t.getBench().add(llPlayer.get((23*(i-1))+2));
					}
					else if(j>=3 && j<=10) {
						if(j<7) {
							t.getStarter().add(llPlayer.get(j+(23*(i-1))));
						}
						else {
							t.getBench().add(llPlayer.get(j+(23*(i-1))));
						}
					}
					else if(j>=11 && j<=17) {
						if(j<14) {
							t.getStarter().add(llPlayer.get(j+(23*(i-1))));
						}
						else {
							t.getBench().add(llPlayer.get(j+(23*(i-1))));
						}
					}
					else if(j>=18 && j<=22) {
						if(j<21) {
							t.getStarter().add(llPlayer.get(j+(23*(i-1))));
						}
						else {
							t.getBench().add(llPlayer.get(j+(23*(i-1))));
						}
					}
			}
			alTeams.add(t);
		}
	}
}