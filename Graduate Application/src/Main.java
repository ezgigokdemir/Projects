
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
   
        Scanner scanner = new Scanner(System.in);
        
        BasvuruYap yeni_kayit = new BasvuruYap();
        
        System.out.println("İşlemler...\n"
                + "1-Eğitim Bilgilerinizi Giriniz\n"
                + "2-Diplomanızı Yükleyin\n"
                + "3-ALES Puanınızı Giriniz\n"
                + "4-Dil Yeterlilk Belgenizi Giriniz\n"
                + "5-Referanslarınızı Giriniz\n"
                + "6-Çıkış için '0' tuşuna basın.");
        
        while(true){
            System.out.print("İşleminizi seçiniz: ");
            int islem = scanner.nextInt();
            if(islem == 0 ){
                System.out.println("Sistemden çıkılıyor....");
                break;
            }
            else if(islem == 1){
                yeni_kayit.egitim_bilgileri();
                
            }
            else if(islem == 2){
                System.out.println("Diplomanız sisteme başarı ile yüklenmiştir.");
            }
            else if(islem == 3){
                yeni_kayit.ales_puani();
                System.out.println("ALES Puanınız sisteme başarı ile yüklenmiştir...");
            }
            else if(islem == 4){
                yeni_kayit.dil_belgesi();
                
            }
            else if(islem == 5){
                yeni_kayit.referanslar();
            }
            else{
                System.out.println("Geçersiz İşlem.....");
            }
        }
                
        
}
    
}
