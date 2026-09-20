import java.util.Scanner;

public class Main {

    static void title() {
        System.out.print("==============================================\n");
        System.out.print("||    SELAMAT DATANG DI BIOSKOP MANAGER!    ||\n");
        System.out.print("==============================================\n");
        System.out.print("\n");
    }

    static void helpmenu() {
        System.out.print("==============================================\n");
        System.out.print("||  Program ini ditujukan sebagai simulasi  ||\n");
        System.out.print("||  dalam mengatur dan mengelola film-film  ||\n");
        System.out.print("||           pada sebuah bioskop.           ||\n");
        System.out.print("||                                          ||\n");
        System.out.print("||                                          ||\n");
        System.out.print("||              COMMAND LIST                ||\n");
        System.out.print("||                 +INPUT                   ||\n");
        System.out.print("||                 +SHOW                    ||\n");
        System.out.print("||                 +UPDATE                  ||\n");
        System.out.print("||                 +DELETE                  ||\n");
        System.out.print("||                 +SEARCH                  ||\n");
        System.out.print("||                 +HELP                    ||\n");
        System.out.print("||                                          ||\n");
        System.out.print("||+ FORMAT INPUT :                          ||\n");
        System.out.print("||INPUT id nama genre hargatiket jumlahjual ||\n");
        System.out.print("||FUNGSI : Menginput film kedalam           ||\n");
        System.out.print("||         data bioskop                     ||\n");
        System.out.print("||                                          ||\n");
        System.out.print("||+ FORMAT SHOW :                           ||\n");
        System.out.print("||SHOW                                      ||\n");
        System.out.print("||FUNGSI : Menampilkan seluruh data dalam   ||\n");
        System.out.print("||         bioskop                          ||\n");
        System.out.print("||                                          ||\n");
        System.out.print("||+ FORMAT UPDATE :                         ||\n");
        System.out.print("||UPDATE id nama genre hargatiket jumlahjual||\n");
        System.out.print("||FUNGSI : Mengganti/memodifikasi data      ||\n");
        System.out.print("||         satu film dalam bioskop          ||\n");
        System.out.print("||                                          ||\n");
        System.out.print("||+ FORMAT DELETE :                         ||\n");
        System.out.print("||DELETE id                                 ||\n");
        System.out.print("||FUNGSI : Menghapus satu data film dalam   ||\n");
        System.out.print("||         bioskop                          ||\n");
        System.out.print("||                                          ||\n");
        System.out.print("||+ FORMAT SEARCH :                         ||\n");
        System.out.print("||SEARCH id                                 ||\n");
        System.out.print("||FUNGSI : Mencari dan menampilkan satu data||\n");
        System.out.print("||         film dalam bioskop               ||\n");
        System.out.print("||                                          ||\n");
        System.out.print("||+ FORMAT HELP :                           ||\n");
        System.out.print("||HELP                                      ||\n");
        System.out.print("||FUNGSI : Menampilkan kembali menu panduan ||\n");
        System.out.print("||         ini                              ||\n");
        System.out.print("==============================================\n");
    }

    static Film search(String id, Film[] datafilm) {
        for (int i = 0; i < 99; i++) {
            Film currentfilm = datafilm[i];
            String filmid = currentfilm.getId();
            if (filmid.equals(id)) {
                return datafilm[i];
            }
        }
        return new Film();
    }

    static boolean updatefilm(String id, Film[] datafilm, Film update) {
        boolean terupdate = false;
        for (int i = 0; i < 99; i++) {
            Film currentfilm = datafilm[i];
            String filmid = currentfilm.getId();
            if (filmid.equals(id)) {
                datafilm[i] = update;
                terupdate = true;
            }
        }
        return terupdate;
    }

    static boolean deletefilm(String id, Film[] datafilm, int[] jumlahfilm) {
        boolean ketemu = false;
        for (int i = 0; i < jumlahfilm[0]; i++) {
            if (datafilm[i].getId().equals(id)) {
                ketemu = true;
                // Shift all subsequent objects one index to the left
                for (int j = i; j < jumlahfilm[0] - 1; j++) {
                    datafilm[j] = datafilm[j + 1];
                }

                datafilm[jumlahfilm[0] - 1] = new Film();
                jumlahfilm[0] = jumlahfilm[0] - 1;

                break;
            }
        }
        return ketemu;
    }

    static void hitungpanjang(int[] lengths, Film[] datafilm) {
        // lengths array maps to: [pid, pfilm, pgenre, pharga, ptiket]
        int i = 0;
        while (!datafilm[i].getId().equals("kosong")) {
            int id = datafilm[i].getId().length();
            int nama = datafilm[i].getNama().length();
            int genre = datafilm[i].getGenre().length();
            int harga = String.valueOf(datafilm[i].getHarga()).length();
            int tiket = String.valueOf(datafilm[i].getJual()).length();
            
            if (id > lengths[0]) lengths[0] = id;
            if (nama > lengths[1]) lengths[1] = nama;
            if (genre > lengths[2]) lengths[2] = genre;
            if (harga > lengths[3]) lengths[3] = harga;
            if (tiket > lengths[4]) lengths[4] = tiket;
            
            i += 1;
        }
    }

    static void judul(int pid, int pfilm, int pgenre, int pharga, int ptiket, int pall) {
        for (int j = 0; j < pall; j++) {
            System.out.print("=");
        }
        System.out.print("\n");

        float sid = (pid + 1 - 2);
        System.out.print("|");
        System.out.print("ID");
        for (int j = 0; j < Math.round(sid); j++) {
            System.out.print(" ");
        }

        float sfilm = (pfilm + 1 - 10);
        System.out.print("|");
        System.out.print("JUDUL FILM");
        for (int j = 0; j < Math.round(sfilm); j++) {
            System.out.print(" ");
        }

        float sgenre = (pgenre + 1 - 5);
        System.out.print("|");
        System.out.print("GENRE");
        for (int j = 0; j < Math.round(sgenre); j++) {
            System.out.print(" ");
        }

        float sharga = (pharga + 1 - 11);
        System.out.print("|");
        System.out.print("HARGA TIKET");
        for (int j = 0; j < Math.round(sharga); j++) {
            System.out.print(" ");
        }

        float stiket = (ptiket + 1 - 7);
        System.out.print("|");
        System.out.print("TERJUAL");
        for (int j = 0; j < Math.round(stiket); j++) {
            System.out.print(" ");
        }
        System.out.print("|\n");
        for (int j = 0; j < pall; j++) {
            System.out.print("=");
        }
        System.out.print("\n");
    }

    static void showall(Film[] datafilm) {
        System.out.print("\n");
        int i = 0;
        int[] lengths = {2, 10, 5, 11, 7}; // pid, pfilm, pgenre, pharga, ptiket
        hitungpanjang(lengths, datafilm);
        
        int pid = lengths[0];
        int pfilm = lengths[1];
        int pgenre = lengths[2];
        int pharga = lengths[3];
        int ptiket = lengths[4];
        
        int pall = pid + pfilm + pgenre + pharga + ptiket + 11;
        judul(pid, pfilm, pgenre, pharga, ptiket, pall);
        
        while (!datafilm[i].getId().equals("kosong")) {
            // ID
            float sid = (pid + 1 - datafilm[i].getId().length());
            System.out.print("|");
            System.out.print(datafilm[i].getId());
            for (int j = 0; j < Math.round(sid); j++) {
                System.out.print(" ");
            }

            // NAMA
            float sfilm = (pfilm + 1 - datafilm[i].getNama().length());
            System.out.print("|");
            System.out.print(datafilm[i].getNama());
            for (int j = 0; j < Math.round(sfilm); j++) {
                System.out.print(" ");
            }

            // GENRE
            float sgenre = (pgenre + 1 - datafilm[i].getGenre().length());
            System.out.print("|");
            System.out.print(datafilm[i].getGenre());
            for (int j = 0; j < Math.round(sgenre); j++) {
                System.out.print(" ");
            }

            // HARGA
            float sharga = (pharga + 1 - String.valueOf(datafilm[i].getHarga()).length());
            System.out.print("|");
            System.out.print(datafilm[i].getHarga());
            for (int j = 0; j < Math.round(sharga); j++) {
                System.out.print(" ");
            }

            // TIKET
            float stiket = (ptiket + 1 - String.valueOf(datafilm[i].getJual()).length());
            System.out.print("|");
            System.out.print(datafilm[i].getJual());
            for (int j = 0; j < Math.round(stiket); j++) {
                System.out.print(" ");
            }
            System.out.print("|\n");

            i += 1;
        }
        for (int j = 0; j < pall; j++) {
            System.out.print("=");
        }
        System.out.print("\n\n");
    }

    static void hitungpanjangsatu(int[] lengths, Film datafilm) {
        int id = datafilm.getId().length();
        int nama = datafilm.getNama().length();
        int genre = datafilm.getGenre().length();
        int harga = String.valueOf(datafilm.getHarga()).length();
        int tiket = String.valueOf(datafilm.getJual()).length();
        
        if (id > lengths[0]) lengths[0] = id;
        if (nama > lengths[1]) lengths[1] = nama;
        if (genre > lengths[2]) lengths[2] = genre;
        if (harga > lengths[3]) lengths[3] = harga;
        if (tiket > lengths[4]) lengths[4] = tiket;
    }

    static void showsatu(Film datafilm) {
        System.out.print("\n");
        int[] lengths = {2, 10, 5, 11, 7}; // pid, pfilm, pgenre, pharga, ptiket
        hitungpanjangsatu(lengths, datafilm);
        
        int pid = lengths[0];
        int pfilm = lengths[1];
        int pgenre = lengths[2];
        int pharga = lengths[3];
        int ptiket = lengths[4];
        
        int pall = pid + pfilm + pgenre + pharga + ptiket + 11;
        judul(pid, pfilm, pgenre, pharga, ptiket, pall);

        // ID
        float sid = (pid + 1 - datafilm.getId().length());
        System.out.print("|");
        System.out.print(datafilm.getId());
        for (int j = 0; j < Math.round(sid); j++) {
            System.out.print(" ");
        }

        // NAMA
        float sfilm = (pfilm + 1 - datafilm.getNama().length());
        System.out.print("|");
        System.out.print(datafilm.getNama());
        for (int j = 0; j < Math.round(sfilm); j++) {
            System.out.print(" ");
        }

        // GENRE
        float sgenre = (pgenre + 1 - datafilm.getGenre().length());
        System.out.print("|");
        System.out.print(datafilm.getGenre());
        for (int j = 0; j < Math.round(sgenre); j++) {
            System.out.print(" ");
        }

        // HARGA
        float sharga = (pharga + 1 - String.valueOf(datafilm.getHarga()).length());
        System.out.print("|");
        System.out.print(datafilm.getHarga());
        for (int j = 0; j < Math.round(sharga); j++) {
            System.out.print(" ");
        }

        // TIKET
        float stiket = (ptiket + 1 - String.valueOf(datafilm.getJual()).length());
        System.out.print("|");
        System.out.print(datafilm.getJual());
        for (int j = 0; j < Math.round(stiket); j++) {
            System.out.print(" ");
        }
        System.out.print("|\n");

        for (int j = 0; j < pall; j++) {
            System.out.print("=");
        }
        System.out.print("\n\n");
    }

    public static void main(String[] args) {
        title();
        helpmenu();
        
        Film[] datafilm = new Film[99];
        
        for (int i = 0; i < 99; i++) {
            datafilm[i] = new Film();
        }
        
        int[] jumlahfilm = {0}; 
        Scanner scanner = new Scanner(System.in);
        String input;
        
        do {
            System.out.print("INPUT : ");
            if (!scanner.hasNext()) break;
            input = scanner.next();
            
            if (!input.equals("EXIT")) {
                String id;
                if (input.equals("INPUT")) {
                    id = scanner.next();
                    String nama = scanner.next();
                    String genre = scanner.next();
                    int tiket = scanner.nextInt();
                    int jual = scanner.nextInt();

                    Film filminput = new Film(id, nama, genre, tiket, jual);
                    datafilm[jumlahfilm[0]] = filminput;
                    jumlahfilm[0] += 1;
                } 
                else if (input.equals("SHOW")) {
                    showall(datafilm);
                } 
                else if (input.equals("UPDATE")) {
                    id = scanner.next();
                    String nama = scanner.next();
                    String genre = scanner.next();
                    int tiket = scanner.nextInt();
                    int jual = scanner.nextInt();

                    Film update = new Film(id, nama, genre, tiket, jual);
                    boolean akhir = updatefilm(id, datafilm, update);
                    if (akhir) {
                        System.out.print("DATA FILM BERHASIL DIUPDATE!\n");
                    } else {
                        System.out.print("DATA FILM GAGAL DIUPDATE!\n");
                    }
                } 
                else if (input.equals("DELETE")) {
                    id = scanner.next();
                    boolean hasil = deletefilm(id, datafilm, jumlahfilm);
                    if (hasil) {
                        System.out.print("FILM YANG DIPILIH BERHASIL DIHAPUS!\n");
                    } else {
                        System.out.print("FILM YANG DIPILIH GAGAL DIHAPUS!\n");
                    }
                } 
                else if (input.equals("SEARCH")) {
                    id = scanner.next();
                    Film cari = search(id, datafilm);
                    if (!cari.getId().equals("kosong")) {
                        showsatu(cari);
                    } else {
                        System.out.print("ID FILM TIDAK COCOK DENGAN FILM MANAPUN!\n");
                    }
                } 
                else if (input.equals("HELP")) {
                    helpmenu();
                } 
                else {
                    System.out.print("COMMAND INVALID!\n");
                }
            }

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        } while (!input.equals("EXIT"));
        
        scanner.close();
    }
}
