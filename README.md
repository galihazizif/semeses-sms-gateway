# semeses-sms-gateway
Menjadikan ponsel android anda sebagai SMS sender.

---

Anda dapat membuild ulang source Semeses dengan akun gcm/fcm milik anda sendiri. Namun anda juga bisa menggunakan server semeses untuk mengirimkan SMS yang 
tentunya melalui ponsel android anda sendiri.

Untuk dapat menggunakan Semeses (dengan server Semeses)

1. Unduh apk Semeses pada tautan berikut ini
[Unduh](https://github.com/galihazizif/semeses-sms-gateway/releases)

2. Install dan jalankan

3. Tunggu hingga muncul token registrasi, token registrasi pada app Semeses didapatkan dengan cara meregistrasikan ponsel anda ke layanan Google Firebase CM

4. Salin token registrasi tersebut untuk digunakan sebagai identitas ponsel anda.

Berikut ini alur jalannya pengiriman SMS menggunakan Semeses

![Skema semeses](http://semeses.rempoah.com/web/img/skema1.png)

Untuk mengirimkan SMS menggunakan Semeses, pastikan anda sudah melakukan 4 langkah diatas. Anda bisa mengirimkan pesan yang akan dikirim menggunakan
HTTP Request ke server Semeses yang nantinya akan diteruskan kepada layanan Firebase Cloud Messaging.

	https://semeses.rempoah.com/sendsms?reg_token=<reg_token>&recipient=<recipient>&message=<message>

	<reg_token> : Token registrasi yang ada pada app Semeses.
	<recipient> : Nomor penerima SMS
	<message>	: Pesan SMS


Contoh: 


	https://semeses.rempoah.com/sendsms?reg_token=abcdefghi123456&recipient=081234567890&message=HalloWord


Respon:

Jika sukses maka anda akan mendapatkan respon dalam bentuk seperti berikut ini.

	{"status":0,"content":"OK"}

