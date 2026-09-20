#include <string>

using namespace std;

class film
{
	private: 
		string id;
		string nama;
		string genre;
		int harga;
		int jual;
	public: 
		//constructor I 
		film(){
			id = "kosong";
		}

		//constructor II (ada paremeter)
		film(string id, string nama, string genre, int harga, int jual){
			this->id = id;
			this->nama = nama;
			this->genre = genre;
			this->harga = harga;
			this->jual = jual;
		}

		//destructor
		~film(){}

		//getter
		string getid(){
			return id;
		}
		string getnama(){
			return nama;
		}
		string getgenre(){
			return genre;
		}
		int getharga(){
			return harga;
		}
		int getjual(){
			return jual;
		}

		//setter
		void setid(string text){
			id = text;
		}
		void setnama(string text){
			nama = text;
		}
		void setgenre(string text){
			genre = text;
		}
		void setharga(int angka){
			harga = angka;
		}
		void setjual(int angka){
			jual = angka;
		}
};