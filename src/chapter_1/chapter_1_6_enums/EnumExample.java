package chapter_1.chapter_1_6_enums;

public class EnumExample {
	public static void main(String[] args) {
		System.out.println(Seasons2.SUMMER.name());
	}
}

enum Season
{
   WINTER("WINTER"), 
   AUTUMN("https://sit.domain.com:2019/"), 
   SPRING("https://cit.domain.com:8080/"), 
   SUMMER("https://dev.domain.com:21323/");

   private String url;

   Season(String envUrl) {
       this.url = envUrl;
   }

   public String getUrl() {
       return url;
   }
}