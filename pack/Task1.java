package my.pack;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {
	
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 Map<String, Double> firstCur = new HashMap<>();
		 String firstCurrency="";
		 String secondCurrency="";
	     double a=0.0;
	     double kof=0.0;
	     double res=0.0;
		 
		 System.out.print("Введите наименование валюты (usd, eur, rub, byr), которую вы хотели бы конвертировать: "); 
		 firstCurrency=saveEnteredCurrency();
		 if(firstCurrency.equals("")) {
			 System.out.print("Введите наименование валюты (usd, eur, rub, byr), которую вы хотели бы конвертировать: "); 
			 firstCurrency=saveEnteredCurrency(); 
		 }

		System.out.print("Введите наименование валюты (usd, eur, rub, byr), в которую вы хотели бы конвертировать: ");
		secondCurrency=saveEnteredCurrency();
		 if(secondCurrency.equals("")) {
			 System.out.print("Введите наименование валюты (usd, eur, rub, byr), в которую вы хотели бы конвертировать: ");
			 secondCurrency=saveEnteredCurrency(); 
		 }
		
		if(!firstCurrency.equalsIgnoreCase(secondCurrency)) {
			System.out.print("Введите сумму, которую вы хотели бы конвертировать: ");
			if (sc.hasNextDouble()) { 
				double temp=sc.nextDouble();
				if(temp>0.0) {
					a=temp;
					System.out.println(secondCurrency+" "+a);
				}else System.out.println("Введено некорректное наименование валюты "+temp);
				}else System.out.println("Введена некорректная сумма");
		}else System.out.print("Указаны одинаковые типы валют, конвертация невозможна");
		
		firstCur.putAll(chooseCurrency(firstCurrency));
		kof=findCoefficient(secondCurrency, firstCur);
		res=kof*a;
		System.out.println("Результат конвертирования: "+a+firstCurrency+" = "+res+secondCurrency);

	}
	public static Map<String, Double> chooseCurrency(String firstCurrency) {
		Map<String, Double> firstCur = new HashMap<>();
		 Map<String, Double> usdKurs = new HashMap<>();
		 Map<String, Double> eurKurs = new HashMap<>();
		 Map<String, Double> rubKurs = new HashMap<>();
		 Map<String, Double> byrKurs = new HashMap<>();
		 usdKurs.put("eur", 0.03);
		 usdKurs.put("rub", 60.0);
		 usdKurs.put("byr", 3.0);
		 eurKurs.put("usd", 0.03);
		 eurKurs.put("rub", 70.0);
		 eurKurs.put("byr", 3.0);
		 rubKurs.put("eur", 0.07);
		 rubKurs.put("usd", 0.06);
		 rubKurs.put("byr", 0.3);
		 byrKurs.put("eur", 0.3);
		 byrKurs.put("usd", 0.2);
		 byrKurs.put("rub", 30.0);
		 
			switch (firstCurrency.toLowerCase()) {
	        case  ("usd"):
	        	firstCur.putAll(usdKurs);
	            break;
	        case ("eur"):
	        	firstCur.putAll(eurKurs);
	            break;
	        case ("rub"):
	        	firstCur.putAll(rubKurs);
	            break;
	        case ("byr"):
	        	firstCur.putAll(byrKurs);
	            break;
	        default:
	        	System.out.println("Что-то пошло не так при первой перезаписи");
	            break;
	    }	
		return firstCur;
	}
	
	public static Double findCoefficient(String secondCurrency, Map<String, Double> listOfCoefficients){
		Double coefficient=0.0;
		
		switch (secondCurrency.toLowerCase()) {
        case  ("usd"):
        	coefficient=listOfCoefficients.get("usd");
            break;
        case ("eur"):
        	coefficient=listOfCoefficients.get("eur");
            break;
        case ("rub"):
        	coefficient=listOfCoefficients.get("rub");
            break;
        case ("byr"):
        	coefficient=listOfCoefficients.get("byr");
            break;
        default:
        	System.out.println("Что-то пошло не так при второй перезаписи");
            break;
    }
		
		return coefficient;
	} 
	
	public static String saveEnteredCurrency() {
		
		String saveEnteredCurrency="";
		Scanner sc = new Scanner(System.in); 
		if (sc.hasNext()) { 
			String temp=sc.next();
			if(temp.equalsIgnoreCase("usd")||temp.equalsIgnoreCase("eur")||temp.equalsIgnoreCase("rub")||temp.equalsIgnoreCase("byr")) {
				saveEnteredCurrency=temp;
				System.out.println(saveEnteredCurrency+" "+temp);
			}else System.out.println("Введено некорректное наименование валюты "+temp);
			}
		
		if(saveEnteredCurrency.equals("")) {
			saveEnteredCurrency=saveEnteredCurrency();
		}
		//sc.close();
		return saveEnteredCurrency;
		
	}

}
