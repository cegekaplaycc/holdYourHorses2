package views;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;

import java.util.ArrayList;

import models.Horse;

import org.junit.Test;

import play.data.Form;
import play.mvc.Content;
import views.html.horseMarket;

import com.google.common.collect.Lists;

public class HorseMarketTemplateTest {

	@Test
	public void renderTemplate() {
		ArrayList<Horse> horses = Lists.newArrayList(new Horse(20), new Horse(30));
		
	    Content html = horseMarket.render(horses, new Form<Horse>(Horse.class));	    
	    
	    assertThat(contentType(html)).isEqualTo("text/html");
	    assertThat(contentAsString(html)).contains("<td>20</td>");
	    assertThat(contentAsString(html)).contains("<td>30</td>");
	}
	
}
