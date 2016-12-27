package org.example.soccerlegends;


import org.example.soccerlegends.R;

import android.app.Activity;
import android.content.Intent;
//import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class HistorySoccer extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.detail);
		//Intent i = getIntent();

		
		//LinearLayout linear;

		//TextView text;
		
		//linear = new LinearLayout(this);

		//linear.setOrientation(LinearLayout.VERTICAL); 
		//linear.setBackgroundResource(R.drawable.cbg2);
		setContentView(R.layout.detail);

		TextView tv = (TextView)this.findViewById(R.id.about_content);
		TextView tv1 = (TextView)this.findViewById(R.id.stitle);


		tv1.setText("History of Soccer");
		
		tv.setText("\n\tIt is hard to say who invented soccer and there are several opinions regarding this subject. Sure, the country that invented modern soccer as it is known today is England, but historical references attest that diverse forms of soccer were around for ages." +"\n\n"+
				"\tFor example, a military document found in China attested a game called Cuju, played around the second century B.C. It wasn't soccer per se, but it did involve kicking a leather ball through a small hole in a piece of silk cloth strung between two high poles. " +"\n\n"+
				"\tIt definitely wasn't an easy game to play! Just consider how many of today's strikers have problems missing a 7 meter wide goal, let alone put a rugged leather ball through a small hole." +"\n\n"+
				"\tOther Asian countries show us that the history of the game of soccer was probably born in this area. But the pleasure of kicking a ball with some sort of purpose wasn't necessarily solely Asian." +"\n\n"+
				"\tMesoamerican civilizations also devised a game played with rubber balls, which resembled a combination between soccer, basketball and volleyball. The game involved two teams, playing in a sort of basin dug below ground level, with baskets strapped in several locations on the side walls. The teams would then have to kick the ball towards these baskets, and score a goal." +"\n\n"+
				"\tObviously, kicking a ball through a ring somewhere up on the wall is hard enough as it is, but considering the fact that they were playing with a rubber ball, which is harder to control, gives us a perspective on why central and south Americans are so skilled at modern day soccer." +"\n"+
				"Ancient Greeks and Romans also had their own versions of the game, or they imported the ones coming from Asia. One game, called Pheninda was a combination between soccer and rugby, which was popular amongst the ranks of the Imperial armies." +"\n"+
				"The History of Soccer in Middle Ages" +"\n\n"+
				"\tAs we go forward on the history of soccer timeline, we notice that the game has gradually entered European territory, Europe being the place where modern day soccer will start in several centuries. Middle age soccer is covered in a combination of myth and historical facts. One popular form of the game (Mob soccer) involved entire villages or towns and was rather chaotic." +"\n\n"+
				"\tThe teams could have unlimited players, as long as they were from the same village or town. Both teams had to kick the ball towards specific landmarks, and defend their own." +"\n\n"+
				"\tTo add more chaos, the ball was made out of inflated pigs' bladders, or leather skins stuffed with all sorts of materials." +"\n\n"+
				"\tPicture two masses of people running towards a poor pig bladder ball, kicking, stomping, punching and pushing each other in the attempt to kick the object to some area..." +"\n\n"+
				"\tIn medieval France, a game called 'La Choule' was usually played in town gatherings, such as just after Sunday church, or on special occasions or holidays." +"\n\n"+
						"\tThe game itself looked like a combination of soccer, handball, hockey, baseball and kickboxing, since the players of each team had to strike the ball into the opponent's goal, using whatever means necessary and whatever accessories necessary." +"\n\n"+
						" \tFor example, one record shows that players were allowed to use sticks or clubs to hit the ball around, although it wasn't always the ball that got hit." +"\n\n"+
						"\tThe game was violent in nature and I assume there were plenty occasions where the after-church Choule match ended up with another trip to the church to confess some violent sins." +"\n\n"+
						"\tIn England, the game was surrounded by an aura of violence and was considered a dangerous and sinful game. As such, it was banned in 1314 by Nicholas de Farndone, the Mayor of London." +"\n"+
						"The motive of the ban, as read from de Farndone's decree, is that the game causes 'great noise in the city, caused by hustling over large foot balls' of the public 'from which many evils might arise'. That is also the first reference to the game as 'football'." +"\n"+
								"Despite this ban, soccer became to grow in medieval England and it was not long that it was introduced in English public schools in order to keep young boys fit." +"\n"+
								"The game started becoming slightly more organized, with well defined teams, positions, referees and coaches (deemed 'training masters' in early records)." +"\n"+
								
										"Still, rules would differ from school to school, but the essence was still there." +"\n"+
										"The examples above come from very clear historical references, but like I said, there's also a great deal of myth surrounding the history of soccer during that period. One legend says that soccer was actually born at public executions, where the henchman would deprive a poor soul of his head, then toss it into the crowd where the masses would kick it with anger." +"\n"+
										"Although the barbaric nature of this 'game' would fit the mentality of the time, there's no proof that this kind of events actually sparked what will soon become organized soccer." +"\n"+
												"The History of Soccer ñ Birth of the Modern Game" +"\n"+
												"Since soccer was growing strong in English public schools, the idea of having an organized tournament sparked in the 19th century." +"\n"+
												"At the beginning of the century, soccer matches between schools were played on a regular basis, but since not every school had the same rules, it was hard to find common grounds for larger tournaments. Soccer also spread beyond the school yard and institutions, factories and other organizations started creating their own teams." +"\n"+
												"In 1862, a solicitor by the name of Cobb Morley, formed a semi-professional soccer club in Barnes, called the Barnes Club. Seeing that the game needs more organization if it were to be played properly, he suggested creating a governing body for soccer in a local newspaper and the idea grew roots." +"\n"+
												"On 26 October, 1863, his idea was put to practice, as the founding members of several soccer clubs around London met in the Freemasons' Tavern in the English Capital, setting the base for the future organization, who was deemed 'Football Association'." +"\n"+
												"Cobb Morley is rightfully considered the father of soccer, but that's not just because he was the one to spark the idea of the Football Association. He also drew up the Laws of the Game, probably the most important document in the history of soccer, since it held all the official rules around which the game would be played." +"\n"+
												"Cobb Morley's rules were accepted by the Football Association on the 8th of December, 1863 and have since stood as the game's constitution, although they were slightly modified throughout time to meet the needs of modern soccer." +"\n"+
												"The History of Soccer ñ Engulfing Earth" +"\n"+
												"It only took around 3 decades after the first official rules of soccer were laid down by Cobb Morley and the English Football Association and the game was already wide spread throughout Europe, Australia and the Americas." +"\n"+
												"The first national teams were formed at the brink of the 20th century and national leagues were popping up all over the World." +"\n"+
												"By the 1930s, many of the European and American nations were already part of an international soccer governing body called FIFA (Federation of International Football Associations)." +"\n"+
												"Although not everyone joined FIFA as soon as it was formed, throughout time, countries started seeing the benefits of an international governing body for soccer and got in." +"\n"+
												"Despite its romantic advance in the 19th century, we're currently living the best days in the history of soccer. Today, soccer is truly an international sport and it's statistically proven to be the most popular game in the World, being enjoyed by almost 3 billion people world wide, on all continents." +"\n"+
												"The World Cup, a tournament organized by FIFA every four years, is considered one of the most important international tournaments, together with the Olympics." +"\n"+
												"Not all countries will participate in a World Cup though, as reaching the final stages of the tournament requires going through a tough qualification process that each continent organizes separately." +"\n"+
												"Grateful thanks to legends who served this legendery game in the course added value to them and in turn the legendary game." +"\n"+
												"Hence this app is named as 'legendary football' tribute to the legendary game.");
		
		
	       View legends2 = findViewById(R.id.backbutton1);
	        legends2.setOnClickListener(this);

		//linear.addView(text);



	}
	
	
	
    public void onClick(View v) {
    	switch (v.getId()) {
    	case R.id.backbutton1:

            startActivity(new Intent("org.example.soccerlegends.MyApps"));

    		break;

    	}
    }

	
	
	
}