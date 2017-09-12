# semeses-sms-gateway
Menjadikan ponsel android anda sebagai SMS sender.

---

Anda dapat membuild ulang source Semeses dengan akun gcm/fcm milik anda sendiri. Namun anda juga bisa menggunakan server semeses untuk mengirimkan SMS yang 
tentunya melalui ponsel android anda sendiri.

Untuk dapat menggunakan Semeses (dengan server Semeses)

1. Unduh apk Semeses pada app/build/outputs/apk

2. Install dan jalankan

3. Tunggu hingga muncul token registrasi, token registrasi pada app Semeses didapatkan dengan cara meregistrasikan ponsel anda ke layanan Google Firebase CM

4. Salin token registrasi tersebut untuk digunakan sebagai identitas ponsel anda.

Berikut ini alur jalannya pengiriman SMS menggunakan Semeses

![Skema semeses](http://semeses.rempoah.com/web/img/skema1.png)

This app will utilize your phone as an sms sender. We can send the message through GCM. 
Semeses will send the SMS immediatly after the payload received.
