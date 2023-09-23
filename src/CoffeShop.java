import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class CoffeShop {
    static ArrayList<Order> orders = new ArrayList();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
      
        int pilih;
        do {
            System.out.println("--------------------");
            System.out.println("Bucks Coffe");
            System.out.println("--------------------");
            System.out.println("1. Buy Coffe");
            System.out.println("2. Check Out");
            System.out.println("3. Exit");
            System.out.println("--------------------");
            System.out.print("Pilihan Mu : ");
            pilih = sc.nextInt();
            sc.nextLine();

            if(pilih == 1){
                orders = buyCoffe(orders);
            } else if (pilih == 2) {
                System.out.println(orders.size());
                orders = checkOut(orders);

            }
        } while (pilih != 3);
        orders.clear();
    }

    private static ArrayList<Order> checkOut(ArrayList<Order> orders) {
        int harga, jumlah, total = 0, bayar;
        System.out.println("Jumlah Order : " + String.valueOf(orders.size()));
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-5s | %-15s | %-13s | %-13s |  %-13s |  %-13s |  %-13s |", "No.", "Name", "Type", "Extra", "Qty", "Price", "Total");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        int num = 1;
        for (int i = 0; i < orders.size(); i++) {
            harga = (orders.get(i).getQty() * orders.get(i).getName().length() * 100);
            jumlah = 0;
            if (orders.get(i).getSugar().equals("y") || orders.get(i).getSugar().equals("Y")) {
                jumlah = orders.get(i).getQty() * harga;
            } else {
                jumlah = (int) ((orders.get(i).getQty() * harga) + (orders.get(i).getQty() * 0.03));
                // System.out.println(orders.get(i).getQty() * harga);
                // System.out.println(orders.get(i).getQty() * 0.03);
                // System.out.println(((orders.get(i).getQty() * harga) + (orders.get(i).getQty() * 0.03)));

            }

            System.out.printf("| %-5s | %-15s | %-13s | %-13s |  %-13s |  %-13s | %-13s |",
                    num++,
                    orders.get(i).getName(),
                    orders.get(i).getType(),
                    orders.get(i).getSugar(),
                    orders.get(i).getQty(),
                    harga,
                    jumlah);
            total += jumlah;
                            System.out.println();

        }
                System.out.println("---------------------------------------------------------------------------------------------------------------");
                System.out.println();
                System.out.println("Total :" + total);
                
                boolean ok;
                do{
                    System.out.print("Bayar :");
                    bayar = sc.nextInt();
                    sc.nextLine();
                    ok = cekBayar(total, bayar);
                } while (ok == false);
                System.out.println("Kembalian : " + Math.abs(total - bayar));
                System.out.println("Successfully Add New Order !");
                System.out.println("Press enter to Continue..");
                sc.nextLine();
                sc.nextLine();
                orders.clear();
                return orders;
    }

    private static boolean cekBayar(int total, int bayar) {
        boolean ok = false;
        if (bayar >= total) {
            ok = true;
        }
        return ok;
    }

    private static ArrayList<Order> buyCoffe(ArrayList<Order> orders) {
        String nama, tipe, gula;
        int qty;

        System.out.print("Input Nama Kopi : ");
        nama = sc.nextLine();
        boolean ok;
        do {
            System.out.print("Input Nama Tipe [ Cappucino, Latte, Americano ] : ");
            tipe = sc.nextLine();
            ok = cekKopi(tipe);
        } while (ok == false);
        do {
            System.out.print("Tambah Gula [ Y / T ] : ");
            gula = sc.nextLine();
            ok = cekGula(gula);
        } while (ok == false);
        
        System.out.print("Quantity : ");
        qty = sc.nextInt();
        System.out.println(nama + " " + tipe + " " + gula + " " + qty + " ");
        orders.add(new Order(nama,gula,tipe,qty));
        return orders;
    }
    private static boolean cekGula(String gula) {

        boolean ok = false;
        if (gula.equals("y") || gula.equals("Y") || gula.equals("t") || gula.equals("T")) {
            ok = true;
        }
        return ok;
    }

    private static boolean cekKopi(String tipe) {
        boolean ok = false;
        if (tipe.equals("Cappucino") || tipe.equals("Latte") || tipe.equals("Americano")) {
            ok = true;
        }
        return ok;
    }
}
