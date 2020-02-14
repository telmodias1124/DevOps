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

		llPlayer.add(ClassFactory.creatPlayer("Hugo","Lloris",new PlayerStatistic(19,82),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Steve","Mandanda",new PlayerStatistic(17,80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Alphonse","Areola",new PlayerStatistic(22,81),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Benjamin","Pavard",new PlayerStatistic(57,80),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Presnel","Kimpembe",new PlayerStatistic(46,80),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Raphäel","Varane",new PlayerStatistic(51,86),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Samuel","Umtiti",new PlayerStatistic(67,85),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Adil","Rami",new PlayerStatistic(51,75),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Djibril","Sidibé",new PlayerStatistic(62,74),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Lucas","Hernandez",new PlayerStatistic(54,83),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Benjamin","Mendy",new PlayerStatistic(54,78),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Paul","Pogba",new PlayerStatistic(82,65),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Corentin","Tolisso",new PlayerStatistic(73,74),"M"));

		llPlayer.add(ClassFactory.creatPlayer("N’Golo","Kanté",new PlayerStatistic(58,88),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Blaise","Matudi",new PlayerStatistic(67,83),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Steven","Nzonzi",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Antoine","Griezmann",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Thomas","Lemar",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Olivier","Giroud",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Kylian","Mbappé",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Ousmane","Dembélé",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Nabil","Fekir",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Florian","Thauvin",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));


		//ALLEMAGNE


		llPlayer.add(ClassFactory.creatPlayer("Manuel","Neuer",new PlayerStatistic(25,87),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Marc-André","Ter Stegen",new PlayerStatistic(21,87),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Kevin","Trapp",new PlayerStatistic(18,81),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Jérôme","Boateng",new PlayerStatistic(54,82),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Matthias","Ginter",new PlayerStatistic(58,82),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Jonas","Hector",new PlayerStatistic(62,77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Joshua","Kimmich",new PlayerStatistic(68,79),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Mats","Hummels",new PlayerStatistic(63,88),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Marvin","Plattenhardt",new PlayerStatistic(65,75),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Antonio","Rüdiger",new PlayerStatistic(49,83),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Niklas","Süle",new PlayerStatistic(46,87),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Julian","Brandt",new PlayerStatistic(70,43),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Julian","Draxler",new PlayerStatistic(75,49),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Marco","Reus",new PlayerStatistic(82,44),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Leon","Goretzka",new PlayerStatistic(74,73),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Ilkay","Gündogan",new PlayerStatistic(73,72),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Sami","Khedira",new PlayerStatistic(71,78),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Toni","Kroos",new PlayerStatistic(78,67),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Thomas","Müller",new PlayerStatistic(76,49),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Mesut","Ozil",new PlayerStatistic(70,19),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Sebastian","Rudy",new PlayerStatistic(70,74),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Mario","Gomez",new PlayerStatistic(70,74),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Timo","Werner",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		//BELGIQUE

		llPlayer.add(ClassFactory.creatPlayer("Thibault","Courtois",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Simon","Mignolet",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Koen","Casteels",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Toby","Alderweireld",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Thomas","Vemaelen",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Vincent","Kompany",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Jan","Vertonghen",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Thomas","Meunier",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Dedryck","Boyata",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Axel","Wistel",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Kevin","De Bruyne",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Marouane","Fellaini",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Yannick","Carrasco",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Dries","Mertens",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Thorgan","Hazard",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Youri","Tielemans",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Adnan","Januzaj",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Mousa","Dembélé",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Nacer","Chadli",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Leander","Dendoncker",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Romelu","Lukaku",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Eden","Hazard",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Michy","Batsuayi",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		//PEROU

		llPlayer.add(ClassFactory.creatPlayer("Pedro","Gallese",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Carlos","Caceda",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("José","Carvallo",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Alberto","Rodriguez",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Aldo","Corzo",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Anderson","Santamaria",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Miguel","Trauco",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Miguel","Araujo",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Christian","Ramos",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Luis","Advincula",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Nilson","Loyola",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Paolo","Hurtado",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Christian","Cueva",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Renato","Tapia",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Andy","Polo",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Wilder","Cartagena",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Yoshimar","Yotun",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Edison","Flores",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Pedro","Aquino",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Paolo","Guerrero",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Jefferson","Farfan",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Raul","Ruidiaz",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("André","Carrillo",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		//MEXIQUE

		llPlayer.add(ClassFactory.creatPlayer("José","de Jesus Corona",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Alfredo","Talavera",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Guillermo","Ochoa",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Hugo","Ayala",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Carlos","Salcedo",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Erick","Guitérrez",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Miguel","Layun",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Héctor","Moreno",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Edson","Alvarez",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Jesus","Gallardo",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Rafael","Marquez",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Jonathan","Dos Santos",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Marco","Fabian",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Giovani","Dos Santos",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Hector","Herrera",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Andrés","Guardado",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Javier","Aquino",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Raul","Jiménez",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Carlos","Vela",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Javier","Hernandez",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Jesus","Manuel Corona",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Oribe","Peralta",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Hirving","Lozano",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		//BRESIL

		llPlayer.add(ClassFactory.creatPlayer("Alisson","Becker",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Cassio","Ramos",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Ederson","De Moraes",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Thiago","Silva",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Miranda","De Souza",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Pedro","Geromel",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Filipe","Luis",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Marcelo","Silva Junior",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Marcos","Aoas Correa",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Danilo","Da Silva",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Fagner","Lemos",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Carlos","Henrique",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Renato","Augusto",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Philippe","Coutinho",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("José","Paulo",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Fernando","Luiz Roza",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Frederico","Rodrigues",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Willian","Da Silva",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Douglas","Costa",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Gabriel","Jesus",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Neymar","Da Silva",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Roberto","Firmino",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Taison","Barcellos",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));



		//POLOGNE

		llPlayer.add(ClassFactory.creatPlayer("Wojciech","Szczesny",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Bartosz","Bialkowski",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Lukasz","Fibianski",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Michal","Pazdan",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Artur","Jedrzejczyk",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Thiago","Rangel",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Jan","Bednarek",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Kamil","Glik",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Bartosz","Bereszynski",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Lukasz","Piszczek",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Jackek","Goralski",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Karol","Linetty",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Grzegorz","Krychowiak",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Kamil","Grosicki",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Maciej","Rybus",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Jakub","Blaszczykowski",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Slawomir","Peszko",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Piotr","Zielinski",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Rafal","Kurzawa",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Arkadiusz","Milik",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Robert","Lewandowski",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Lukasz","Teodorcyk",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Sawid","Kownacki",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		//SUISSE

		llPlayer.add(ClassFactory.creatPlayer("Yann","Sommer",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Yvon","Mvogo",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Roman","Burki",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Stephan","Lichtsteiner",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Francois","Moubandje",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Nico","Elvedi",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Manuel","Akanji",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Michael","Lang",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Ricardo","Rodriguez",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Johan","Djourou",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Fabian","Schar",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Remo","Freuler",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Granit","Xhaka",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Valon","Behrami",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Steven","Zuber",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Blerim","Dzemaili",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Gelson","Fernandes",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Denis","Zakaria",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Xherdan","Shaqiri",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Breel","Embolo",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Haris","Seferovic",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Mario","Gavranovic",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Josip","Drmic",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		//URUGUAY

		llPlayer.add(ClassFactory.creatPlayer("Fernando","Muslera",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Martin","Campana",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Martin","Silva",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("José","Giménez",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Diego","Godin",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Guillermo","Varela",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Gaston","Silva",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Maxi","Pereira",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Sebastian","Coates",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Martin","Caceres",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Carlos","Sanchez",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Rodrigo","Bentacur",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Cristian","Rodriguez",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Nahitan","Nandez",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Giorgian","De Arrascaeta",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Lucas","Torreira",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Matias","Vecino",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Diego","Laxalt",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Luis","Suarez",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Cristhian","Stuani",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Maxi","Gomez",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Jonathan","Urretaviscaya",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Edinson","Cavani",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		//PORTUGUAL

		llPlayer.add(ClassFactory.creatPlayer("Rui","Patricio",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Anthony","Lopes",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Antonio","Alberto",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Bruno","Alves",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Képler","Laveran",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Raphael","Guerreiro",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("José","Fonte",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Ruben","Dias",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Ricardo","Pereira",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Mario","Rui",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Cédric","Soares",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Manuel","Fernandes",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Joao","Moutinho",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Joao","Mario",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Bernando","Silva",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("William","Carvalho",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Bruno","Fernandes",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Adrien","Silva",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Cristiano","Ronaldo",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("André","Silva",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Goncalo","Guedes",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Gelson","Martins",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Ricardo","Quaresma",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		//ANGLETERRE

		llPlayer.add(ClassFactory.creatPlayer("Jordan","Pickford",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Jack","Bultand",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Nick","Pope",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Kyle","Walker",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Danny","Rose",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("John","Stones",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Harry","Maguire",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Kieran","Trippier",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Gary","Cahill",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Phil","Jones",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Trent","Alexander-Arnold",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Eric","Dier",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Jesse","Lingard",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Jordan","Henderson",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Raheem","Sterling",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Fabian","Delph",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Ashley","Young",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Dele","Alli",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Ruben","Loftus-Cheek",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Harry","Kane",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Jamie","Vardy",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Danny","Welbeck",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Marcus","Rashford",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		//CROATIE

		llPlayer.add(ClassFactory.creatPlayer("Dominik","Livakovic",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Lovre","Kalinic",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Danjiel","Subasic",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Sime","Vrsaljko",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Ivan","Strinic",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Vedran","Corluka",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Dejan","Lovren",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Tin","Jedvaj",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Duje","Caeleta-Car",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Domagoj","Vida",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Josip","Pivaric",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Ivan","Rakitic",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Mateo","Kovacic",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Luka","Modric",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Marcelo","Brozovic",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Filip","Bradaric",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Milan","Badelj",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Ivan","Perisic",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Adrej","Kramaric",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Nikola","Kalinic",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Mario","Mandzukic",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Ante","Rebic",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Marko","Pjaca",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		//ARGENTINE

		llPlayer.add(ClassFactory.creatPlayer("Nahuel","Guzman",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Franco","Armani",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Willy","Caballero",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Gabriel","Mercado",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Nicolas","Tagliafico",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Cristian","Ansaldi",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Federico","Fazio",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Marcos","Acuna",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Marcos","Rojo",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Nicolas","Otamendi",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Eduardo","Salvio",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Lucas","Biglia",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Ever","Banega",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Angel","Di Maria",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Maximilianio","Meza",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Javier","Mascherano",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Enzo","Perez",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Giovani","Lo Celso",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Cristian","Pavon",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Gonzalo","Higuain",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Lionel","Messi",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Sergio","Aguero",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Paulo","Dybala",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));



		//ESPAGNE

		llPlayer.add(ClassFactory.creatPlayer("David","De Gea",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Kepa","Arrizabalaga",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Pepe","Reina",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Daniel","Carvajal",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Gerard","Pique",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("José","Fernandez",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Alvaro","Odriozola",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Cesar","Azpilicueta",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Sergio","Ramos",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Nacho","Monreal",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Jordi","Alba",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Sergio","Busquets",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Andres","Iniesta",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Saul","Esclapez",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Jorge","Merodio",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Thiago","Alcantara",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("David","Silva",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Francisco","Roman",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Rodrigo","Machado",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Lucas","Vazquez",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Iago","Aspas",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Diego","Costa",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Marco","Asensio",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		//COLOMBIE

		llPlayer.add(ClassFactory.creatPlayer("David","Ospina",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Camilo","Vargas",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("José","Fernando Cuadrado",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Cristian","Zapata",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Oscar","Murillo",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Santiago","Arias",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Yerry","Mina",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Johan","Mojica",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Farid","Diaz",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Davinson","Sanchez",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Wilmar","Barrios",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Carlos","Sanchez",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Abel","Aguilar",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("James","Rodriguez",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Juan","Cuadrado",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Mateus","Uribe",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Jefferson","Lerma",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Juan","Fernando Quintero",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Carlos","Bacca",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Radalel","Falcao",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Luis","Muriel",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Miguel","Borja",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("José","Izquierdo",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		//DANEMARK

		llPlayer.add(ClassFactory.creatPlayer("Kasper","Schmeichel",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Jonas","Lossl",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Frederik","Ronnow",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G"));

		llPlayer.add(ClassFactory.creatPlayer("Jannik","Vestergaard",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Simon","Kjaer",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Jonas","Knudsen",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Andreas","Christensen",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Mathias","Jorgensen",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Henrik","Dalsgaard",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Jens","Stryger Larsen",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D"));

		llPlayer.add(ClassFactory.creatPlayer("Michael","Krohn-Dehli",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Wiliam","Kvist",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Thomas","Delaney",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Christian","Eriksen",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Lukas","Lerager",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Lasse","Schone",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Pione","Sisto",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M"));

		llPlayer.add(ClassFactory.creatPlayer("Nicolai","Jorgensen",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Martin","Braithwaite",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Kasper","Dolberg",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Viktor","Fischer",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Yussuf","Poulsen",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

		llPlayer.add(ClassFactory.creatPlayer("Andreas","Cornelius",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A"));

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