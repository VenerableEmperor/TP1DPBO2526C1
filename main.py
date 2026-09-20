from film import Film

def title():
    print("==============================================")
    print("||    SELAMAT DATANG DI BIOSKOP MANAGER!    ||")
    print("==============================================")
    print()

def helpmenu():
    print("==============================================")
    print("||  Program ini ditujukan sebagai simulasi  ||")
    print("||  dalam mengatur dan mengelola film-film  ||")
    print("||           pada sebuah bioskop.           ||")
    print("||                                          ||")
    print("||                                          ||")
    print("||              COMMAND LIST                ||")
    print("||                 +INPUT                   ||")
    print("||                 +SHOW                    ||")
    print("||                 +UPDATE                  ||")
    print("||                 +DELETE                  ||")
    print("||                 +SEARCH                  ||")
    print("||                 +HELP                    ||")
    print("||                                          ||")
    print("||+ FORMAT INPUT :                          ||")
    print("||INPUT id nama genre hargatiket jumlahjual ||")
    print("||FUNGSI : Menginput film kedalam           ||")
    print("||         data bioskop                     ||")
    print("||                                          ||")
    print("||+ FORMAT SHOW :                           ||")
    print("||SHOW                                      ||")
    print("||FUNGSI : Menampilkan seluruh data dalam   ||")
    print("||         bioskop                          ||")
    print("||                                          ||")
    print("||+ FORMAT UPDATE :                         ||")
    print("||UPDATE id nama genre hargatiket jumlahjual||")
    print("||FUNGSI : Mengganti/memodifikasi data      ||")
    print("||         satu film dalam bioskop          ||")
    print("||                                          ||")
    print("||+ FORMAT DELETE :                         ||")
    print("||DELETE id                                 ||")
    print("||FUNGSI : Menghapus satu data film dalam   ||")
    print("||         bioskop                          ||")
    print("||                                          ||")
    print("||+ FORMAT SEARCH :                         ||")
    print("||SEARCH id                                 ||")
    print("||FUNGSI : Mencari dan menampilkan satu data||")
    print("||         film dalam bioskop               ||")
    print("||                                          ||")
    print("||+ FORMAT HELP :                           ||")
    print("||HELP                                      ||")
    print("||FUNGSI : Menampilkan kembali menu panduan ||")
    print("||         ini                              ||")
    print("==============================================")

def search(id_val, datafilm):
    for currentfilm in datafilm:
        if currentfilm.getid() == id_val:
            return currentfilm
    return Film()

def updatefilm(id_val, datafilm, update):
    terupdate = False
    for i in range(len(datafilm)):
        if datafilm[i].getid() == id_val:
            datafilm[i] = update
            terupdate = True
    return terupdate

def deletefilm(id_val, datafilm):
    ketemu = False
    for i in range(len(datafilm)):
        if datafilm[i].getid() == id_val:
            ketemu = True
            datafilm.pop(i)
            break
    return ketemu

def hitungpanjang(datafilm):
    pid, pfilm, pgenre, pharga, ptiket = 2, 10, 5, 11, 7
    for f in datafilm:
        id_len = len(f.getid())
        nama_len = len(f.getnama())
        genre_len = len(f.getgenre())
        harga_len = len(str(f.getharga()))
        tiket_len = len(str(f.getjual()))
        
        if id_len > pid: pid = id_len
        if nama_len > pfilm: pfilm = nama_len
        if genre_len > pgenre: pgenre = genre_len
        if harga_len > pharga: pharga = harga_len
        if tiket_len > ptiket: ptiket = tiket_len
        
    return pid, pfilm, pgenre, pharga, ptiket

def judul(pid, pfilm, pgenre, pharga, ptiket, pall):
    print("=" * pall)
    
    sid = (pid + 1 - 2)
    print("|ID" + " " * int(round(sid)), end="")

    sfilm = (pfilm + 1 - 10)
    print("|JUDUL FILM" + " " * int(round(sfilm)), end="")

    sgenre = (pgenre + 1 - 5)
    print("|GENRE" + " " * int(round(sgenre)), end="")

    sharga = (pharga + 1 - 11)
    print("|HARGA TIKET" + " " * int(round(sharga)), end="")

    stiket = (ptiket + 1 - 7)
    print("|TERJUAL" + " " * int(round(stiket)) + "|")
    
    print("=" * pall)

def showall(datafilm):
    print()
    pid, pfilm, pgenre, pharga, ptiket = hitungpanjang(datafilm)
    pall = pid + pfilm + pgenre + pharga + ptiket + 11
    judul(pid, pfilm, pgenre, pharga, ptiket, pall)
    
    for f in datafilm:
        sid = (pid + 1 - len(f.getid()))
        print("|" + f.getid() + " " * int(round(sid)), end="")

        sfilm = (pfilm + 1 - len(f.getnama()))
        print("|" + f.getnama() + " " * int(round(sfilm)), end="")

        sgenre = (pgenre + 1 - len(f.getgenre()))
        print("|" + f.getgenre() + " " * int(round(sgenre)), end="")

        sharga = (pharga + 1 - len(str(f.getharga())))
        print("|" + str(f.getharga()) + " " * int(round(sharga)), end="")

        stiket = (ptiket + 1 - len(str(f.getjual())))
        print("|" + str(f.getjual()) + " " * int(round(stiket)) + "|\n", end="")
        
    print("=" * pall)
    print("\n")

def hitungpanjangsatu(f):
    pid, pfilm, pgenre, pharga, ptiket = 2, 10, 5, 11, 7
    
    if len(f.getid()) > pid: pid = len(f.getid())
    if len(f.getnama()) > pfilm: pfilm = len(f.getnama())
    if len(f.getgenre()) > pgenre: pgenre = len(f.getgenre())
    if len(str(f.getharga())) > pharga: pharga = len(str(f.getharga()))
    if len(str(f.getjual())) > ptiket: ptiket = len(str(f.getjual()))
    
    return pid, pfilm, pgenre, pharga, ptiket

def showsatu(f):
    print()
    pid, pfilm, pgenre, pharga, ptiket = hitungpanjangsatu(f)
    pall = pid + pfilm + pgenre + pharga + ptiket + 11
    judul(pid, pfilm, pgenre, pharga, ptiket, pall)

    sid = (pid + 1 - len(f.getid()))
    print("|" + f.getid() + " " * int(round(sid)), end="")

    sfilm = (pfilm + 1 - len(f.getnama()))
    print("|" + f.getnama() + " " * int(round(sfilm)), end="")

    sgenre = (pgenre + 1 - len(f.getgenre()))
    print("|" + f.getgenre() + " " * int(round(sgenre)), end="")

    sharga = (pharga + 1 - len(str(f.getharga())))
    print("|" + str(f.getharga()) + " " * int(round(sharga)), end="")

    stiket = (ptiket + 1 - len(str(f.getjual())))
    print("|" + str(f.getjual()) + " " * int(round(stiket)) + "|\n", end="")

    print("=" * pall)
    print("\n")

def main():
    title()
    helpmenu()
    datafilm = []
    
    while True:
        try:
            tokens = input("INPUT : ").strip().split()
        except EOFError:
            break
            
        if not tokens:
            continue
            
        command = tokens[0]
        
        if command == "EXIT":
            break
            
        if command == "INPUT" and len(tokens) >= 6:
            id_val = tokens[1]
            nama = tokens[2]
            genre = tokens[3]
            tiket = int(tokens[4])
            jual = int(tokens[5])
            
            filminput = Film(id_val, nama, genre, tiket, jual)
            datafilm.append(filminput)
            
        elif command == "SHOW":
            showall(datafilm)
            
        elif command == "UPDATE" and len(tokens) >= 6:
            id_val = tokens[1]
            nama = tokens[2]
            genre = tokens[3]
            tiket = int(tokens[4])
            jual = int(tokens[5])
            
            update = Film(id_val, nama, genre, tiket, jual)
            akhir = updatefilm(id_val, datafilm, update)
            if akhir:
                print("DATA FILM BERHASIL DIUPDATE!")
            else:
                print("DATA FILM GAGAL DIUPDATE!")
                
        elif command == "DELETE" and len(tokens) >= 2:
            id_val = tokens[1]
            hasil = deletefilm(id_val, datafilm)
            if hasil:
                print("FILM YANG DIPILIH BERHASIL DIHAPUS!")
            else:
                print("FILM YANG DIPILIH GAGAL DIHAPUS!")
                
        elif command == "SEARCH" and len(tokens) >= 2:
            id_val = tokens[1]
            cari = search(id_val, datafilm)
            if cari.getid() != "kosong":
                showsatu(cari)
            else:
                print("ID FILM TIDAK COCOK DENGAN FILM MANAPUN!")
                
        elif command == "HELP":
            helpmenu()
            
        else:
            if command not in ["INPUT", "SHOW", "UPDATE", "DELETE", "SEARCH", "HELP", "EXIT"]:
                print("COMMAND INVALID!")

if __name__ == "__main__":
    main()