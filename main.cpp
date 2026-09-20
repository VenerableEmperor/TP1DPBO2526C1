#include <bits/stdc++.h>
#include "film.cpp"

using namespace std;

void title(){
	cout << "==============================================\n";
	cout << "||    SELAMAT DATANG DI BIOSKOP MANAGER!    ||\n";
	cout << "==============================================\n";
	cout << "\n";
}

void helpmenu(){
	cout << "==============================================\n";
	cout << "||  Program ini ditujukan sebagai simulasi  ||\n";
	cout << "||  dalam mengatur dan mengelola film-film  ||\n";
	cout << "||           pada sebuah bioskop.           ||\n";
	cout << "||                                          ||\n";
	cout << "||                                          ||\n";
	cout << "||              COMMAND LIST                ||\n";
	cout << "||                 +INPUT                   ||\n";
	cout << "||                 +SHOW                    ||\n";
	cout << "||                 +UPDATE                  ||\n";
	cout << "||                 +DELETE                  ||\n";
	cout << "||                 +SEARCH                  ||\n";
	cout << "||                 +HELP                    ||\n";
	cout << "||                                          ||\n";
	cout << "||+ FORMAT INPUT :                          ||\n";
	cout << "||INPUT id nama genre hargatiket jumlahjual ||\n";
	cout << "||FUNGSI : Menginput film kedalam           ||\n";
	cout << "||         data bioskop                     ||\n";
	cout << "||                                          ||\n";
	cout << "||+ FORMAT SHOW :                           ||\n";
	cout << "||SHOW                                      ||\n";
	cout << "||FUNGSI : Menampilkan seluruh data dalam   ||\n";
	cout << "||         bioskop                          ||\n";
	cout << "||                                          ||\n";
	cout << "||+ FORMAT UPDATE :                         ||\n";
	cout << "||UPDATE id nama genre hargatiket jumlahjual||\n";
	cout << "||FUNGSI : Mengganti/memodifikasi data      ||\n";
	cout << "||         satu film dalam bioskop          ||\n";
	cout << "||                                          ||\n";
	cout << "||+ FORMAT DELETE :                         ||\n";
	cout << "||DELETE id                                 ||\n";
	cout << "||FUNGSI : Menghapus satu data film dalam   ||\n";
	cout << "||         bioskop                          ||\n";
	cout << "||                                          ||\n";
	cout << "||+ FORMAT SEARCH :                         ||\n";
	cout << "||SEARCH id                                 ||\n";
	cout << "||FUNGSI : Mencari dan menampilkan satu data||\n";
	cout << "||         film dalam bioskop               ||\n";
	cout << "||                                          ||\n";
	cout << "||+ FORMAT HELP :                           ||\n";
	cout << "||HELP                                      ||\n";
	cout << "||FUNGSI : Menampilkan kembali menu panduan ||\n";
	cout << "||         ini                              ||\n";
	cout << "==============================================\n";
}

film search(string id, film datafilm[]){
	for (int i = 0; i < 99;i++){
		film currentfilm = datafilm[i];
		string filmid = currentfilm.getid();
		if (filmid == id){ 
			return datafilm[i];
		}
	}
	film error;
	return error; 
}

bool updatefilm(string id, film datafilm[], film update){
	bool terupdate;
	for (int i = 0; i < 99;i++){
		film currentfilm = datafilm[i];
		string filmid = currentfilm.getid();
		if (filmid == id){ 
			datafilm[i] = update;
			terupdate = true;
		}
	} 
	return terupdate;
}

bool deletefilm(string id, film datafilm[], int *jumlahfilm){
	bool ketemu;
	for (int i = 0; i < *jumlahfilm; i++) {
        if (datafilm[i].getid() == id) {
            ketemu = true;
            // Shift all subsequent objects one index to the left
            for (int j = i; j < *jumlahfilm - 1; j++) {
                datafilm[j] = datafilm[j+1];
            }
            
            datafilm[*jumlahfilm - 1] = film(); 
            *jumlahfilm = *jumlahfilm - 1; 
            
            break;
        }
	}
	return ketemu;
}

void hitungpanjang(int *pid, int *pfilm, int *pgenre, int *pharga, int *ptiket, film datafilm[]){
	int i = 0;
	while (datafilm[i].getid() != "kosong"){
		int id = datafilm[i].getid().length();
		int nama = datafilm[i].getnama().length();
		int genre = datafilm[i].getgenre().length();
		int harga = to_string(datafilm[i].getharga()).length();
		int tiket = to_string(datafilm[i].getjual()).length();
		if (id > *pid){
			*pid = id;
		}
		if (nama > *pfilm) {
			*pfilm = nama;
		}
		if (genre > *pgenre) {
			*pgenre = genre;
		}
		if (harga > *pharga) {
			*pharga = harga;
		}
		if (tiket > *ptiket) {
			*ptiket = tiket;
		}
		i += 1;
	}
}

void judul(int pid, int pfilm, int pgenre, int pharga, int ptiket, int pall){
	for (int j = 0; j < pall; j++){
		cout << "=";
	}
	cout << "\n";

	float sid = (pid + 1 - 2);
	cout << "|";
	cout << "ID";
	for (int j = 0; j < round(sid);j++){
		cout << " ";
	}

	float sfilm = (pfilm + 1 - 10);
	cout << "|";
	cout << "JUDUL FILM";
	for (int j = 0; j < round(sfilm);j++){
		cout << " ";
	}

	float sgenre = (pgenre + 1 - 5);
	cout << "|";
	cout << "GENRE";
	for (int j = 0; j < round(sgenre);j++){
		cout << " ";
	}

	float sharga = (pharga + 1 - 11);
	cout << "|";
	cout << "HARGA TIKET";
	for (int j = 0; j < round(sharga);j++){
		cout << " ";
	}

	float stiket = (ptiket + 1 - 7);
	cout << "|";
	cout << "TERJUAL";
	for (int j = 0; j < round(stiket);j++){
		cout << " ";
	}
	cout << "|\n";
	for (int j = 0; j < pall; j++){
		cout << "=";
	}
	cout << "\n";
}

void showall(film datafilm[]){
	cout << "\n";
	int i = 0;
	int pid = 2;
	int pfilm = 10;
	int pgenre = 5;
	int pharga = 11;
	int ptiket = 7;
	hitungpanjang(&pid, &pfilm, &pgenre, &pharga, &ptiket, datafilm);
	int pall = pid + pfilm + pgenre + pharga + ptiket + 11;
	judul(pid, pfilm, pgenre, pharga, ptiket, pall);
	while (datafilm[i].getid() != "kosong"){
		//NAMA
		float sid = (pid + 1 - datafilm[i].getid().length());
		cout << "|";
		cout << datafilm[i].getid() ;
		for (int j = 0; j < round(sid);j++){
			cout << " ";
		}

		//NAMA
		float sfilm = (pfilm + 1 - datafilm[i].getnama().length());
		cout << "|";
		cout << datafilm[i].getnama() ;
		for (int j = 0; j < round(sfilm);j++){
			cout << " ";
		}

		//GENRE
		float sgenre = (pgenre + 1 - datafilm[i].getgenre().length());
		cout << "|";
		cout << datafilm[i].getgenre() ;
		for (int j = 0; j < round(sgenre);j++){
			cout << " ";
		}

		//HARGA
		float sharga = (pharga + 1 - to_string(datafilm[i].getharga()).length());
		cout << "|";
		cout << datafilm[i].getharga() ;
		for (int j = 0; j < round(sharga);j++){
			cout << " ";
		}

		//TIKET
		float stiket = (ptiket + 1 - to_string(datafilm[i].getjual()).length());
		cout << "|";
		cout << datafilm[i].getjual() ;
		for (int j = 0; j < round(stiket);j++){
			cout << " ";
		}
		cout << "|\n";

		i += 1;
	}
	for (int j = 0; j < pall; j++){
		cout << "=";
	}
	cout << "\n\n";
}

void hitungpanjangsatu(int *pid, int *pfilm, int *pgenre, int *pharga, int *ptiket, film datafilm){
	int id = datafilm.getid().length();
	int nama = datafilm.getnama().length();
	int genre = datafilm.getgenre().length();
	int harga = to_string(datafilm.getharga()).length();
	int tiket = to_string(datafilm.getjual()).length();
	if (id > *pid){
		*pid = id;
	}
	if (nama > *pfilm) {
		*pfilm = nama;
	}
	if (genre > *pgenre) {
		*pgenre = genre;
	}
	if (harga > *pharga) {
		*pharga = harga;
	}
	if (tiket > *ptiket) {
		*ptiket = tiket;
	}
}


void showsatu(film datafilm){
	cout << "\n";
	int i = 0;
	int pid = 2;
	int pfilm = 10;
	int pgenre = 5;
	int pharga = 11;
	int ptiket = 7;
	hitungpanjangsatu(&pid, &pfilm, &pgenre, &pharga, &ptiket, datafilm);
	int pall = pid + pfilm + pgenre + pharga + ptiket + 11;
	judul(pid, pfilm, pgenre, pharga, ptiket, pall);

	//NAMA
	float sid = (pid + 1 - datafilm.getid().length());
	cout << "|";
	cout << datafilm.getid() ;
	for (int j = 0; j < round(sid);j++){
		cout << " ";
	}

	//NAMA
	float sfilm = (pfilm + 1 - datafilm.getnama().length());
	cout << "|";
	cout << datafilm.getnama() ;
	for (int j = 0; j < round(sfilm);j++){
		cout << " ";
	}

	//GENRE
	float sgenre = (pgenre + 1 - datafilm.getgenre().length());
	cout << "|";
	cout << datafilm.getgenre() ;
	for (int j = 0; j < round(sgenre);j++){
		cout << " ";
	}

	//HARGA
	float sharga = (pharga + 1 - to_string(datafilm.getharga()).length());
	cout << "|";
	cout << datafilm.getharga() ;
	for (int j = 0; j < round(sharga);j++){
		cout << " ";
	}

	//TIKET
	float stiket = (ptiket + 1 - to_string(datafilm.getjual()).length());
	cout << "|";
	cout << datafilm.getjual() ;
	for (int j = 0; j < round(stiket);j++){
		cout << " ";
	}
	cout << "|\n";


	for (int j = 0; j < pall; j++){
		cout << "=";
	}
	cout << "\n\n";
}

void clearcin(){
	cin.clear();
	cin.ignore(numeric_limits<streamsize>::max(),'\n');
}



int main(){
	title();
	helpmenu();
	film datafilm[99];
	int jumlahfilm = 0;
	string input;
	do { 
		cout << "INPUT : ";
		cin >> input;
		if (input != "EXIT"){ 
			string id; 
			if (input == "INPUT"){
				cin >> id;
				film filminput;
				string nama, genre;
				int tiket, jual;
				cin >> nama; cin >> genre;
				cin >> tiket; cin >> jual;

				filminput = film(id, nama, genre, tiket, jual);
				datafilm[jumlahfilm] = filminput;
				jumlahfilm += 1;
			}
			else if (input == "SHOW"){
				showall(datafilm);
			}
			else if (input == "UPDATE"){
				cin >> id;
				string nama, genre;
				int tiket, jual;
				cin >> nama; cin >> genre;
				cin >> tiket; cin >> jual;
				
				film update; 
				update = film(id, nama, genre, tiket, jual);
				bool akhir = updatefilm(id, datafilm, update);
				if (akhir == true){
					cout << "DATA FILM BERHASIL DIUPDATE!\n";
				}
				else {
					cout << "DATA FILM GAGAL DIUPDATE!\n";
				}
			}
			else if (input == "DELETE"){
				cin >> id; 
				bool hasil = deletefilm(id, datafilm, &jumlahfilm);
				if (hasil == true) {
					cout << "FILM YANG DIPILIH BERHASIL DIHAPUS!\n"; 
				}
				else {
					cout << "FILM YANG DIPILIH GAGAL DIHAPUS!\n"; 
				}
			}
			else if (input == "SEARCH"){
				cin >> id; 
				film cari; 
				cari = search(id, datafilm);
				if (cari.getid() != "kosong") {
					showsatu(cari);
				}
				else { 
					cout << "ID FILM TIDAK COCOK DENGAN FILM MANAPUN!\n";
				}
			}
			else if (input == "HELP"){
				helpmenu();
			}
			else {
				cout << "COMMAND INVALID!\n";
			}
		}
		clearcin();
	}while (input != "EXIT");
	return 0; 
}

//g++ main.cpp film.cpp -o test.exe