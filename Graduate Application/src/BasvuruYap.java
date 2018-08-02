
import java.util.Scanner;

public class BasvuruYap implements IKayıt_Islemleri{
    
    Scanner scanner = new Scanner(System.in);
    
    public void egitim_bilgileri(){
        System.out.print("Mezun olduğunuz üniversite: ");
        String uni = scanner.nextLine();
        System.out.print("Bölümünüz: ");
        String bolum = scanner.nextLine();
        
    }
    
    @Override
    public void diploma() {
        System.out.println("Diplomanız başarıyla sisteme yüklenmiştir....");
    }

    @Override
    public void dil_belgesi() {
        System.out.print("Dil yeterliliğinizi gösteren bir belge var mı?\t(1.Evet 2.Hayır) :");
        int islem = scanner.nextInt();
        scanner.nextLine();
        switch(islem){
            case 1:
                System.out.print("Sınav adı: ");
                String sinav = scanner.nextLine();
                System.out.println("Puan: ");
                double puan = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Belgeniz başarıyla sisteme yüklendi....");
                break;
            case 2:
                System.out.println("Dil yeterlilik belgeniz YOK olarak sisteme kaydedilmiştir."
                        + "Daha sonra sisteme yükleyebilirsiniz.");
                break;
            default:
                System.out.println("Geçersiz işlem....");
        }
       
    }

    @Override
    public String mezuniyet_derecesi() {
        System.out.print("Mezuniyet Dereceniz: ");
        double derece = scanner.nextInt();
        scanner.nextLine();
        return "Ortalama: "+derece;
    }

    @Override
    public String ales_puani() {
        System.out.print("ALES Puanınızı giriniz: ");
        double alespuani = scanner.nextInt();
        return "ALES Puanı: "+alespuani;
    }

    @Override
    public void referanslar() {
        System.out.println("Lütfen Referans bilgilerini giriniz.");
        System.out.print("Referans 1 :");
        String isim = scanner.nextLine();
        System.out.print("Referans 2 :");
        String isim2 = scanner.nextLine();
        
    }
    
    
    
    
}
