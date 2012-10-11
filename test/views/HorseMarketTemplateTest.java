package views;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;

import java.util.ArrayList;

import models.Horse;

import org.junit.Test;

import com.google.common.collect.Lists;

import play.mvc.Content;
import views.html.horseMarket;

public class HorseMarketTemplateTest {

	@Test
	public void renderTemplate() {
		ArrayList<Horse> horses = Lists.newArrayList(new Horse(20), new Horse(30));
		
	    Content html = horseMarket.render(horses);	    
	    
	    assertThat(contentType(html)).isEqualTo("text/html");
	    assertThat(contentAsString(html)).contains("<li>20</li>");
	    assertThat(contentAsString(html)).contains("<li>30</li>");
	}
	
}