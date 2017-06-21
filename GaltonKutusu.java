/*
    * Galton kutusu (fasulye makinası) Java Örneği

 */
package U07;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Revmin
 */
public class GaltonKutusu {
       public static void main(String []args) {
                Scanner input = new Scanner(System.in);
           System.out.println("Bırakılacak top sayısını girin : ");
           int topSayisi = input.nextInt();
           
           System.out.println("Aşılacak slot sayısını girin : ");
           int slotSayisi =input.nextInt();
           
       
             topAt(topSayisi, slotSayisi);

       }
       
       /*
       * Top atma işleminin başladığı kısım
       * Top sayısı kadar bırakma yapılacak
       */
       
       public static void topAt(int topSayisi, int slot) {
           char[] hucre = new char[slot-1];
           int[] topPozisyonu = new int[slot];
             
           for(int i = 0 ; i<topSayisi; i++) {
           atisBaslat(hucre);
           diziGoruntule(hucre);
               System.out.println();
           pozisyon(hucre,topPozisyonu, slot);
            
           }
           
           /* Topların hangi slotta biriktiğini görmer için */
           
           System.out.println(Arrays.toString(topPozisyonu));
           System.out.println("-------------------------");
           topGoruntule(topPozisyonu);

       }
       
       /*
       * Topların 0 şeklinde görüntülenmesi için önce en yüksek sutun sayısını bulduk.
       * Sutun sayısını mx e atadık.
       * En dış döngü sutun sayısı kadar dönecek. İkinci döngü slot(topPozisyonu) sayısı kadar dönecek
       * mx, pozisyon dizisindeki rakama eşitse sıfır yazacak ve dizi içindeki değeri azaltacak. k döngüsü ile işlem bittiğinde mx, yani sutun sayısı bir azaltılacak.
       */
       
       public static void topGoruntule(int[]topPozisyonu ) {
           
           int yukseklik = 0;
           for(int i=0;i<topPozisyonu.length; i++){
               if(yukseklik<topPozisyonu[i]){
                   yukseklik = topPozisyonu[i];
               }
           }
           int mx = yukseklik;
           
           for(int i=0; i <yukseklik; i++) {
               for(int k=0; k<topPozisyonu.length; k++) {
                   if(mx==topPozisyonu[k]){
                       System.out.print("|0|");
                       topPozisyonu[k]--;
                   }else
                       System.out.print("| |");
               }
               System.out.println();
               mx--;
           }
            
       } 
       
       public static int findMaxY(int[] topPozisyonu){
           int maxYB = 0;
           for(int i =0; i < topPozisyonu.length; i++) {
               if(maxYB < topPozisyonu[i])
                   maxYB = topPozisyonu[i];
           }
           return maxYB;
       }
       
       /*
       * en alta topun hangi noktaya düştüğünü bulmak için önce orta slotu buluyoruz
       * orta slotu bulduktan sonra topun kat ettiği yollara bakıyoruz. 'L' sol; 'R' sağ şeklinde.
       * Sola gittikce ortayı eksilir Sağa gittikçe artar; limitler sıfır ve slot sayısı kadar dır bundan daha küçük veya büyük olamaz
       * Bulunan sonucu, en başta oluşturduğumuz topPozisyonu dizisi ile çağırıyoruz. Dizinin sonundaki "++" topun düştüğü slottaki, top sayısını tutuyor.
       */
       
       
       public static void pozisyon(char [] hucre, int[]topPozisyonu, int slot){
           
           int orta = slot/2;
           for(int i = 0; i< hucre.length; i++) {
               if(hucre[i]=='L' && orta>0)
                   orta--;
               else if(orta < slot-1)
                   orta++;
           }
      //     System.out.println(orta);
           topPozisyonu[orta]++;
       }

       
       /*
       Attığımız topu Görüntülemek için 
       Array.toString methodu ile tek satırda görüntülemede sağlayabilirsiniz.
       */
       
       public static void diziGoruntule(char[] hucre) {
           for(int i = 0; i<hucre.length; i++) {
               if(i==0)
                   System.out.print("[");
;
               
               System.out.printf("%s%s", hucre[i],(i==hucre.length-1)?"]":",");
               

           }
       }
       
       /*
       * rastgele sayı üretiyoruz 2 ile bölümğünden kalan; Çift ise Sol, tek ise Sağ
       */
       public static void atisBaslat(char[] hucre) {
           for(int i=0; i<hucre.length; i++) {
               int randomStart = (int)(Math.random()*10)%2;
               if(randomStart == 0)
                    hucre[i] = 'L';
               else
                   hucre[i] = 'R';
           }
       }
       
       
}
