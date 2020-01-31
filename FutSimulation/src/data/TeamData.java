package data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class TeamData {
	private Random r;
	private LinkedList<String> ll;
	private Team t;
	
	
	public TeamData() {
		r = new Random();
		ll  = new LinkedList <String>();
	}
	
	public void createTeams(ArrayList<Team> alTeams) {
		ll.add("France");
		ll.add("Allemagne");
		ll.add("Belgique");
		ll.add("Perou");
		ll.add("Mexique");
		ll.add("Bresil");
		ll.add("Pologne");
		ll.add("Suisse");
		ll.add("Uruguay");
		ll.add("Portugual");
		ll.add("Angleterre");
		ll.add("Croatie");
		ll.add("Argentine");
		ll.add("Espagne");
		ll.add("Colombie");
		ll.add("Danemark");
		
		//FRANCE

		Player player1 = ClassFactory.creatPlayer("Hugo","Lloris",new PlayerStatistic(19,82),"G");

		Player player2 = ClassFactory.creatPlayer("Steve","Mandanda",new PlayerStatistic(17,80),"G");

		Player player3 = ClassFactory.creatPlayer("Alphonse","Areola",new PlayerStatistic(22,81),"G");

		Player player4 = ClassFactory.creatPlayer("Benjamin","Pavard",new PlayerStatistic(57,80),"D");

		Player player5 = ClassFactory.creatPlayer("Presnel","Kimpembe",new PlayerStatistic(46,80),"D");

		Player player6 = ClassFactory.creatPlayer("Raphäel","Varane",new PlayerStatistic(51,86),"D");

		Player player7 = ClassFactory.creatPlayer("Samuel","Umtiti",new PlayerStatistic(67,85),"D");

		Player player8 = ClassFactory.creatPlayer("Adil","Rami",new PlayerStatistic(51,75),"D");

		Player player9 = ClassFactory.creatPlayer("Djibril","Sidibé",new PlayerStatistic(62,74),"D");

		Player player10 = ClassFactory.creatPlayer("Lucas","Hernandez",new PlayerStatistic(54,83),"D");

		Player player11 = ClassFactory.creatPlayer("Benjamin","Mendy",new PlayerStatistic(54,78),"D");

		Player player12 = ClassFactory.creatPlayer("Paul","Pogba",new PlayerStatistic(82,65),"M");

		Player player13 = ClassFactory.creatPlayer("Corentin","Tolisso",new PlayerStatistic(73,74),"M");

		Player player14 = ClassFactory.creatPlayer("N’Golo","Kanté",new PlayerStatistic(58,88),"M");

		Player player15 = ClassFactory.creatPlayer("Blaise","Matudi",new PlayerStatistic(67,83),"M");

		Player player16 = ClassFactory.creatPlayer("Steven","Nzonzi",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player17 = ClassFactory.creatPlayer("Antoine","Griezmann",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player18 = ClassFactory.creatPlayer("Thomas","Lemar",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player19 = ClassFactory.creatPlayer("Olivier","Giroud",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player20 = ClassFactory.creatPlayer("Kylian","Mbappé",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player21 = ClassFactory.creatPlayer("Ousmane","Dembélé",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player22 = ClassFactory.creatPlayer("Nabil","Fekir",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player23 = ClassFactory.creatPlayer("Florian","Thauvin",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");


		//ALLEMAGNE


		Player player24 = ClassFactory.creatPlayer("Manuel","Neuer",new PlayerStatistic(25,87),"G");

		Player player25 = ClassFactory.creatPlayer("Marc-André","Ter Stegen",new PlayerStatistic(21,87),"G");

		Player player26 = ClassFactory.creatPlayer("Kevin","Trapp",new PlayerStatistic(18,81),"G");

		Player player27 = ClassFactory.creatPlayer("Jérôme","Boateng",new PlayerStatistic(54,82),"D");

		Player player28 = ClassFactory.creatPlayer("Matthias","Ginter",new PlayerStatistic(58,82),"D");

		Player player29 = ClassFactory.creatPlayer("Jonas","Hector",new PlayerStatistic(62,77),"D");

		Player player30 = ClassFactory.creatPlayer("Joshua","Kimmich",new PlayerStatistic(68,79),"D");

		Player player31 = ClassFactory.creatPlayer("Mats","Hummels",new PlayerStatistic(63,88),"D");

		Player player32 = ClassFactory.creatPlayer("Marvin","Plattenhardt",new PlayerStatistic(65,75),"D");

		Player player33 = ClassFactory.creatPlayer("Antonio","Rüdiger",new PlayerStatistic(49,83),"D");

		Player player34 = ClassFactory.creatPlayer("Niklas","Süle",new PlayerStatistic(46,87),"D");

		Player player35 = ClassFactory.creatPlayer("Julian","Brandt",new PlayerStatistic(70,43),"M");

		Player player36 = ClassFactory.creatPlayer("Julian","Draxler",new PlayerStatistic(75,49),"M");

		Player player37 = ClassFactory.creatPlayer("Marco","Reus",new PlayerStatistic(82,44),"M");

		Player player38 = ClassFactory.creatPlayer("Leon","Goretzka",new PlayerStatistic(74,73),"M");

		Player player39 = ClassFactory.creatPlayer("Ilkay","Gündogan",new PlayerStatistic(73,72),"M");

		Player player40 = ClassFactory.creatPlayer("Sami","Khedira",new PlayerStatistic(71,78),"M");

		Player player41 = ClassFactory.creatPlayer("Toni","Kroos",new PlayerStatistic(78,67),"M");

		Player player42 = ClassFactory.creatPlayer("Thomas","Müller",new PlayerStatistic(76,49),"M");

		Player player43 = ClassFactory.creatPlayer("Mesut","Ozil",new PlayerStatistic(70,19),"M");

		Player player44 = ClassFactory.creatPlayer("Sebastian","Rudy",new PlayerStatistic(70,74),"M");

		Player player45 = ClassFactory.creatPlayer("Mario","Gomez",new PlayerStatistic(70,74),"A");

		Player player46 = ClassFactory.creatPlayer("Timo","Werner",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		//BELGIQUE

		Player player47 = ClassFactory.creatPlayer("Thibault","Courtois",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player48 = ClassFactory.creatPlayer("Simon","Mignolet",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player49 = ClassFactory.creatPlayer("Koen","Casteels",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player50 = ClassFactory.creatPlayer("Toby","Alderweireld",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player51 = ClassFactory.creatPlayer("Thomas","Vemaelen",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player52 = ClassFactory.creatPlayer("Vincent","Kompany",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player53 = ClassFactory.creatPlayer("Jan","Vertonghen",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player54 = ClassFactory.creatPlayer("Thomas","Meunier",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player55 = ClassFactory.creatPlayer("Dedryck","Boyata",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player56 = ClassFactory.creatPlayer("Axel","Wistel",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player57 = ClassFactory.creatPlayer("Kevin","De Bruyne",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player58 = ClassFactory.creatPlayer("Marouane","Fellaini",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player59 = ClassFactory.creatPlayer("Yannick","Carrasco",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player60 = ClassFactory.creatPlayer("Dries","Mertens",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player61 = ClassFactory.creatPlayer("Thorgan","Hazard",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player62 = ClassFactory.creatPlayer("Youri","Tielemans",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player63 = ClassFactory.creatPlayer("Adnan","Januzaj",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player64 = ClassFactory.creatPlayer("Mousa","Dembélé",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player65 = ClassFactory.creatPlayer("Nacer","Chadli",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player66 = ClassFactory.creatPlayer("Leander","Dendoncker",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player67 = ClassFactory.creatPlayer("Romelu","Lukaku",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player68 = ClassFactory.creatPlayer("Eden","Hazard",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player69 = ClassFactory.creatPlayer("Michy","Batsuayi",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		//PEROU

		Player player70 = ClassFactory.creatPlayer("Pedro","Gallese",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player71 = ClassFactory.creatPlayer("Carlos","Caceda",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player72 = ClassFactory.creatPlayer("José","Carvallo",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player73 = ClassFactory.creatPlayer("Alberto","Rodriguez",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player74 = ClassFactory.creatPlayer("Aldo","Corzo",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player75 = ClassFactory.creatPlayer("Anderson","Santamaria",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player76 = ClassFactory.creatPlayer("Miguel","Trauco",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player77 = ClassFactory.creatPlayer("Miguel","Araujo",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player78 = ClassFactory.creatPlayer("Christian","Ramos",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player79 = ClassFactory.creatPlayer("Luis","Advincula",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player80 = ClassFactory.creatPlayer("Nilson","Loyola",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player81 = ClassFactory.creatPlayer("Paolo","Hurtado",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player82 = ClassFactory.creatPlayer("Christian","Cueva",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player83 = ClassFactory.creatPlayer("Renato","Tapia",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player84 = ClassFactory.creatPlayer("Andy","Polo",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player85 = ClassFactory.creatPlayer("Wilder","Cartagena",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player86 = ClassFactory.creatPlayer("Yoshimar","Yotun",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player87 = ClassFactory.creatPlayer("Edison","Flores",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player88 = ClassFactory.creatPlayer("Pedro","Aquino",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player89 = ClassFactory.creatPlayer("Paolo","Guerrero",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player90 = ClassFactory.creatPlayer("Jefferson","Farfan",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player91 = ClassFactory.creatPlayer("Raul","Ruidiaz",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player92 = ClassFactory.creatPlayer("André","Carrillo",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		//MEXIQUE

		Player player93 = ClassFactory.creatPlayer("José","de Jesus Corona",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player94 = ClassFactory.creatPlayer("Alfredo","Talavera",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player95 = ClassFactory.creatPlayer("Guillermo","Ochoa",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player96 = ClassFactory.creatPlayer("Hugo","Ayala",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player97 = ClassFactory.creatPlayer("Carlos","Salcedo",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player98 = ClassFactory.creatPlayer("Erick","Guitérrez",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player99 = ClassFactory.creatPlayer("Miguel","Layun",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player100 = ClassFactory.creatPlayer("Héctor","Moreno",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player101 = ClassFactory.creatPlayer("Edson","Alvarez",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player102 = ClassFactory.creatPlayer("Jesus","Gallardo",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player103 = ClassFactory.creatPlayer("Rafael","Marquez",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player104 = ClassFactory.creatPlayer("Jonathan","Dos Santos",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player105 = ClassFactory.creatPlayer("Marco","Fabian",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player106 = ClassFactory.creatPlayer("Giovani","Dos Santos",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player107 = ClassFactory.creatPlayer("Hector","Herrera",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player108 = ClassFactory.creatPlayer("Andrés","Guardado",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player109 = ClassFactory.creatPlayer("Javier","Aquino",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player110 = ClassFactory.creatPlayer("Raul","Jiménez",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player111 = ClassFactory.creatPlayer("Carlos","Vela",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player112 = ClassFactory.creatPlayer("Javier","Hernandez",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player113 = ClassFactory.creatPlayer("Jesus","Manuel Corona",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player114 = ClassFactory.creatPlayer("Oribe","Peralta",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player115 = ClassFactory.creatPlayer("Hirving","Lozano",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		//BRESIL

		Player player116 = ClassFactory.creatPlayer("Alisson","Becker",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player117 = ClassFactory.creatPlayer("Cassio","Ramos",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player118 = ClassFactory.creatPlayer("Ederson","De Moraes",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player119 = ClassFactory.creatPlayer("Thiago","Silva",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player120 = ClassFactory.creatPlayer("Miranda","De Souza",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player121 = ClassFactory.creatPlayer("Pedro","Geromel",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player122 = ClassFactory.creatPlayer("Filipe","Luis",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player123 = ClassFactory.creatPlayer("Marcelo","Silva Junior",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player124 = ClassFactory.creatPlayer("Marcos","Aoas Correa",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player125 = ClassFactory.creatPlayer("Danilo","Da Silva",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player126 = ClassFactory.creatPlayer("Fagner","Lemos",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player127 = ClassFactory.creatPlayer("Carlos","Henrique",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player128 = ClassFactory.creatPlayer("Renato","Augusto",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player129 = ClassFactory.creatPlayer("Philippe","Coutinho",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player130 = ClassFactory.creatPlayer("José","Paulo",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player131 = ClassFactory.creatPlayer("Fernando","Luiz Roza",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player132 = ClassFactory.creatPlayer("Frederico","Rodrigues",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player133 = ClassFactory.creatPlayer("Willian","Da Silva",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player134 = ClassFactory.creatPlayer("Douglas","Costa",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player135 = ClassFactory.creatPlayer("Gabriel","Jesus",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player136 = ClassFactory.creatPlayer("Neymar","Da Silva",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player137 = ClassFactory.creatPlayer("Roberto","Firmino",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player138 = ClassFactory.creatPlayer("Taison","Barcellos",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");



		//POLOGNE

		Player player139 = ClassFactory.creatPlayer("Wojciech","Szczesny",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player140 = ClassFactory.creatPlayer("Bartosz","Bialkowski",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player141 = ClassFactory.creatPlayer("Lukasz","Fibianski",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player142 = ClassFactory.creatPlayer("Michal","Pazdan",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player143 = ClassFactory.creatPlayer("Artur","Jedrzejczyk",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player144 = ClassFactory.creatPlayer("Thiago","Rangel",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player145 = ClassFactory.creatPlayer("Jan","Bednarek",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player146 = ClassFactory.creatPlayer("Kamil","Glik",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player147 = ClassFactory.creatPlayer("Bartosz","Bereszynski",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player148 = ClassFactory.creatPlayer("Lukasz","Piszczek",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player149 = ClassFactory.creatPlayer("Jackek","Goralski",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player150 = ClassFactory.creatPlayer("Karol","Linetty",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player151 = ClassFactory.creatPlayer("Grzegorz","Krychowiak",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player152 = ClassFactory.creatPlayer("Kamil","Grosicki",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player153 = ClassFactory.creatPlayer("Maciej","Rybus",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player154 = ClassFactory.creatPlayer("Jakub","Blaszczykowski",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player155 = ClassFactory.creatPlayer("Slawomir","Peszko",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player156 = ClassFactory.creatPlayer("Piotr","Zielinski",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player157 = ClassFactory.creatPlayer("Rafal","Kurzawa",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player158 = ClassFactory.creatPlayer("Arkadiusz","Milik",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player159 = ClassFactory.creatPlayer("Robert","Lewandowski",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player160 = ClassFactory.creatPlayer("Lukasz","Teodorcyk",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player161 = ClassFactory.creatPlayer("Sawid","Kownacki",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		//SUISSE

		Player player162 = ClassFactory.creatPlayer("Yann","Sommer",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player163 = ClassFactory.creatPlayer("Yvon","Mvogo",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player164 = ClassFactory.creatPlayer("Roman","Burki",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player165 = ClassFactory.creatPlayer("Stephan","Lichtsteiner",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player166 = ClassFactory.creatPlayer("Francois","Moubandje",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player167 = ClassFactory.creatPlayer("Nico","Elvedi",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player168 = ClassFactory.creatPlayer("Manuel","Akanji",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player169 = ClassFactory.creatPlayer("Michael","Lang",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player170 = ClassFactory.creatPlayer("Ricardo","Rodriguez",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player171 = ClassFactory.creatPlayer("Johan","Djourou",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player172 = ClassFactory.creatPlayer("Fabian","Schar",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player173 = ClassFactory.creatPlayer("Remo","Freuler",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player174 = ClassFactory.creatPlayer("Granit","Xhaka",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player175 = ClassFactory.creatPlayer("Valon","Behrami",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player176 = ClassFactory.creatPlayer("Steven","Zuber",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player177 = ClassFactory.creatPlayer("Blerim","Dzemaili",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player178 = ClassFactory.creatPlayer("Gelson","Fernandes",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player179 = ClassFactory.creatPlayer("Denis","Zakaria",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player180 = ClassFactory.creatPlayer("Xherdan","Shaqiri",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player181 = ClassFactory.creatPlayer("Breel","Embolo",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player182 = ClassFactory.creatPlayer("Haris","Seferovic",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player183 = ClassFactory.creatPlayer("Mario","Gavranovic",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player184 = ClassFactory.creatPlayer("Josip","Drmic",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		//URUGUAY

		Player player185 = ClassFactory.creatPlayer("Fernando","Muslera",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player186 = ClassFactory.creatPlayer("Martin","Campana",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player187 = ClassFactory.creatPlayer("Martin","Silva",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player188 = ClassFactory.creatPlayer("José","Giménez",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player189 = ClassFactory.creatPlayer("Diego","Godin",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player190 = ClassFactory.creatPlayer("Guillermo","Varela",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player191 = ClassFactory.creatPlayer("Gaston","Silva",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player192 = ClassFactory.creatPlayer("Maxi","Pereira",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player193 = ClassFactory.creatPlayer("Sebastian","Coates",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player194 = ClassFactory.creatPlayer("Martin","Caceres",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player195 = ClassFactory.creatPlayer("Carlos","Sanchez",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player196 = ClassFactory.creatPlayer("Rodrigo","Bentacur",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player197 = ClassFactory.creatPlayer("Cristian","Rodriguez",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player198 = ClassFactory.creatPlayer("Nahitan","Nandez",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player199 = ClassFactory.creatPlayer("Giorgian","De Arrascaeta",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player200 = ClassFactory.creatPlayer("Lucas","Torreira",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player201 = ClassFactory.creatPlayer("Matias","Vecino",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player202 = ClassFactory.creatPlayer("Diego","Laxalt",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player203 = ClassFactory.creatPlayer("Luis","Suarez",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player204 = ClassFactory.creatPlayer("Cristhian","Stuani",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player205 = ClassFactory.creatPlayer("Maxi","Gomez",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player206 = ClassFactory.creatPlayer("Jonathan","Urretaviscaya",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player207 = ClassFactory.creatPlayer("Edinson","Cavani",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		//PORTUGUAL

		Player player208 = ClassFactory.creatPlayer("Rui","Patricio",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player209 = ClassFactory.creatPlayer("Anthony","Lopes",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player210 = ClassFactory.creatPlayer("Antonio","Alberto",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player211 = ClassFactory.creatPlayer("Bruno","Alves",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player212 = ClassFactory.creatPlayer("Képler","Laveran",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player213 = ClassFactory.creatPlayer("Raphael","Guerreiro",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player214 = ClassFactory.creatPlayer("José","Fonte",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player215 = ClassFactory.creatPlayer("Ruben","Dias",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player216 = ClassFactory.creatPlayer("Ricardo","Pereira",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player217 = ClassFactory.creatPlayer("Mario","Rui",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player218 = ClassFactory.creatPlayer("Cédric","Soares",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player219 = ClassFactory.creatPlayer("Manuel","Fernandes",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player220 = ClassFactory.creatPlayer("Joao","Moutinho",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player221 = ClassFactory.creatPlayer("Joao","Mario",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player222 = ClassFactory.creatPlayer("Bernando","Silva",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player223 = ClassFactory.creatPlayer("William","Carvalho",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player224 = ClassFactory.creatPlayer("Bruno","Fernandes",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player225 = ClassFactory.creatPlayer("Adrien","Silva",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player226 = ClassFactory.creatPlayer("Cristiano","Ronaldo",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player227 = ClassFactory.creatPlayer("André","Silva",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player228 = ClassFactory.creatPlayer("Goncalo","Guedes",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player229 = ClassFactory.creatPlayer("Gelson","Martins",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player230 = ClassFactory.creatPlayer("Ricardo","Quaresma",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		//ANGLETERRE

		Player player231 = ClassFactory.creatPlayer("Jordan","Pickford",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player232 = ClassFactory.creatPlayer("Jack","Bultand",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player233 = ClassFactory.creatPlayer("Nick","Pope",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player234 = ClassFactory.creatPlayer("Kyle","Walker",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player235 = ClassFactory.creatPlayer("Danny","Rose",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player236 = ClassFactory.creatPlayer("John","Stones",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player237 = ClassFactory.creatPlayer("Harry","Maguire",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player238 = ClassFactory.creatPlayer("Kieran","Trippier",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player239 = ClassFactory.creatPlayer("Gary","Cahill",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player240 = ClassFactory.creatPlayer("Phil","Jones",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player241 = ClassFactory.creatPlayer("Trent","Alexander-Arnold",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player242 = ClassFactory.creatPlayer("Eric","Dier",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player243 = ClassFactory.creatPlayer("Jesse","Lingard",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player244 = ClassFactory.creatPlayer("Jordan","Henderson",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player245 = ClassFactory.creatPlayer("Raheem","Sterling",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player246 = ClassFactory.creatPlayer("Fabian","Delph",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player247 = ClassFactory.creatPlayer("Ashley","Young",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player248 = ClassFactory.creatPlayer("Dele","Alli",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player249 = ClassFactory.creatPlayer("Ruben","Loftus-Cheek",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player250 = ClassFactory.creatPlayer("Harry","Kane",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player251 = ClassFactory.creatPlayer("Jamie","Vardy",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player252 = ClassFactory.creatPlayer("Danny","Welbeck",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player253 = ClassFactory.creatPlayer("Marcus","Rashford",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		//CROATIE

		Player player254 = ClassFactory.creatPlayer("Dominik","Livakovic",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player255 = ClassFactory.creatPlayer("Lovre","Kalinic",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player256 = ClassFactory.creatPlayer("Danjiel","Subasic",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player257 = ClassFactory.creatPlayer("Sime","Vrsaljko",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player258 = ClassFactory.creatPlayer("Ivan","Strinic",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player259 = ClassFactory.creatPlayer("Vedran","Corluka",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player260 = ClassFactory.creatPlayer("Dejan","Lovren",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player261 = ClassFactory.creatPlayer("Tin","Jedvaj",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player262 = ClassFactory.creatPlayer("Duje","Caeleta-Car",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player263 = ClassFactory.creatPlayer("Domagoj","Vida",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player264 = ClassFactory.creatPlayer("Josip","Pivaric",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player265 = ClassFactory.creatPlayer("Ivan","Rakitic",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player266 = ClassFactory.creatPlayer("Mateo","Kovacic",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player267 = ClassFactory.creatPlayer("Luka","Modric",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player268 = ClassFactory.creatPlayer("Marcelo","Brozovic",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player269 = ClassFactory.creatPlayer("Filip","Bradaric",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player270 = ClassFactory.creatPlayer("Milan","Badelj",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player271 = ClassFactory.creatPlayer("Ivan","Perisic",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player272 = ClassFactory.creatPlayer("Adrej","Kramaric",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player273 = ClassFactory.creatPlayer("Nikola","Kalinic",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player274 = ClassFactory.creatPlayer("Mario","Mandzukic",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player275 = ClassFactory.creatPlayer("Ante","Rebic",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player276 = ClassFactory.creatPlayer("Marko","Pjaca",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		//ARGENTINE

		Player player277 = ClassFactory.creatPlayer("Nahuel","Guzman",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player278 = ClassFactory.creatPlayer("Franco","Armani",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player279 = ClassFactory.creatPlayer("Willy","Caballero",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player280 = ClassFactory.creatPlayer("Gabriel","Mercado",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player281 = ClassFactory.creatPlayer("Nicolas","Tagliafico",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player282 = ClassFactory.creatPlayer("Cristian","Ansaldi",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player283 = ClassFactory.creatPlayer("Federico","Fazio",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player284 = ClassFactory.creatPlayer("Marcos","Acuna",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player285 = ClassFactory.creatPlayer("Marcos","Rojo",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player286 = ClassFactory.creatPlayer("Nicolas","Otamendi",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player287 = ClassFactory.creatPlayer("Eduardo","Salvio",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player288 = ClassFactory.creatPlayer("Lucas","Biglia",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player289 = ClassFactory.creatPlayer("Ever","Banega",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player290 = ClassFactory.creatPlayer("Angel","Di Maria",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player291 = ClassFactory.creatPlayer("Maximilianio","Meza",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player292 = ClassFactory.creatPlayer("Javier","Mascherano",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player293 = ClassFactory.creatPlayer("Enzo","Perez",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player294 = ClassFactory.creatPlayer("Giovani","Lo Celso",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player295 = ClassFactory.creatPlayer("Cristian","Pavon",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player296 = ClassFactory.creatPlayer("Gonzalo","Higuain",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player297 = ClassFactory.creatPlayer("Lionel","Messi",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player298 = ClassFactory.creatPlayer("Sergio","Aguero",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player299 = ClassFactory.creatPlayer("Paulo","Dybala",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");



		//ESPAGNE

		Player player300 = ClassFactory.creatPlayer("David","De Gea",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player301 = ClassFactory.creatPlayer("Kepa","Arrizabalaga",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player302 = ClassFactory.creatPlayer("Pepe","Reina",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player303 = ClassFactory.creatPlayer("Daniel","Carvajal",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player304 = ClassFactory.creatPlayer("Gerard","Pique",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player305 = ClassFactory.creatPlayer("José","Fernandez",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player306 = ClassFactory.creatPlayer("Alvaro","Odriozola",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player307 = ClassFactory.creatPlayer("Cesar","Azpilicueta",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player308 = ClassFactory.creatPlayer("Sergio","Ramos",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player309 = ClassFactory.creatPlayer("Nacho","Monreal",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player310 = ClassFactory.creatPlayer("Jordi","Alba",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player311 = ClassFactory.creatPlayer("Sergio","Busquets",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player312 = ClassFactory.creatPlayer("Andres","Iniesta",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player313 = ClassFactory.creatPlayer("Saul","Esclapez",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player314 = ClassFactory.creatPlayer("Jorge","Merodio",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player315 = ClassFactory.creatPlayer("Thiago","Alcantara",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player316 = ClassFactory.creatPlayer("David","Silva",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player317 = ClassFactory.creatPlayer("Francisco","Roman",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player318 = ClassFactory.creatPlayer("Rodrigo","Machado",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player319 = ClassFactory.creatPlayer("Lucas","Vazquez",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player320 = ClassFactory.creatPlayer("Iago","Aspas",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player321 = ClassFactory.creatPlayer("Diego","Costa",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player322 = ClassFactory.creatPlayer("Marco","Asensio",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		//COLOMBIE

		Player player323 = ClassFactory.creatPlayer("David","Ospina",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player324 = ClassFactory.creatPlayer("Camilo","Vargas",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player325 = ClassFactory.creatPlayer("José","Fernando Cuadrado",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player326 = ClassFactory.creatPlayer("Cristian","Zapata",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player327 = ClassFactory.creatPlayer("Oscar","Murillo",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player328 = ClassFactory.creatPlayer("Santiago","Arias",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player329 = ClassFactory.creatPlayer("Yerry","Mina",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player330 = ClassFactory.creatPlayer("Johan","Mojica",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player331 = ClassFactory.creatPlayer("Farid","Diaz",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player332 = ClassFactory.creatPlayer("Davinson","Sanchez",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player333 = ClassFactory.creatPlayer("Wilmar","Barrios",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player334 = ClassFactory.creatPlayer("Carlos","Sanchez",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player335 = ClassFactory.creatPlayer("Abel","Aguilar",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player336 = ClassFactory.creatPlayer("James","Rodriguez",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player337 = ClassFactory.creatPlayer("Juan","Cuadrado",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player338 = ClassFactory.creatPlayer("Mateus","Uribe",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player339 = ClassFactory.creatPlayer("Jefferson","Lerma",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player340 = ClassFactory.creatPlayer("Juan","Fernando Quintero",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player341 = ClassFactory.creatPlayer("Carlos","Bacca",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player342 = ClassFactory.creatPlayer("Radalel","Falcao",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player343 = ClassFactory.creatPlayer("Luis","Muriel",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player344 = ClassFactory.creatPlayer("Miguel","Borja",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player345 = ClassFactory.creatPlayer("José","Izquierdo",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		//DANEMARK

		Player player346 = ClassFactory.creatPlayer("Kasper","Schmeichel",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player347 = ClassFactory.creatPlayer("Jonas","Lossl",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player348 = ClassFactory.creatPlayer("Frederik","Ronnow",new PlayerStatistic(r.nextInt(7)+18,r.nextInt(8)+80),"G");

		Player player349 = ClassFactory.creatPlayer("Jannik","Vestergaard",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player350 = ClassFactory.creatPlayer("Simon","Kjaer",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player351 = ClassFactory.creatPlayer("Jonas","Knudsen",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player352 = ClassFactory.creatPlayer("Andreas","Christensen",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player353 = ClassFactory.creatPlayer("Mathias","Jorgensen",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player354 = ClassFactory.creatPlayer("Henrik","Dalsgaard",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player355 = ClassFactory.creatPlayer("Jens","Stryger Larsen",new PlayerStatistic(r.nextInt(15)+50,r.nextInt(11)+77),"D");

		Player player356 = ClassFactory.creatPlayer("Michael","Krohn-Dehli",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player357 = ClassFactory.creatPlayer("Wiliam","Kvist",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player358 = ClassFactory.creatPlayer("Thomas","Delaney",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player359 = ClassFactory.creatPlayer("Christian","Eriksen",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player360 = ClassFactory.creatPlayer("Lukas","Lerager",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player361 = ClassFactory.creatPlayer("Lasse","Schone",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player362 = ClassFactory.creatPlayer("Pione","Sisto",new PlayerStatistic(r.nextInt(18)+67,r.nextInt(15)+55),"M");

		Player player363 = ClassFactory.creatPlayer("Nicolai","Jorgensen",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player364 = ClassFactory.creatPlayer("Martin","Braithwaite",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player365 = ClassFactory.creatPlayer("Kasper","Dolberg",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player366 = ClassFactory.creatPlayer("Viktor","Fischer",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player367 = ClassFactory.creatPlayer("Yussuf","Poulsen",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		Player player368 = ClassFactory.creatPlayer("Andreas","Cornelius",new PlayerStatistic(r.nextInt(10)+75,r.nextInt(10)+30),"A");

		for(int i=0; i<16; i++) {
			t = new Team(ll.get(i));
			for()
		}
	}
}