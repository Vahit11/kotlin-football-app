Düzenleme işlemi devam ediyor...

# [APK'yı indir!](https://disk.yandex.com.tr/d/RqyEKWb4rjdXGg)
```diff
https://disk.yandex.com.tr/d/RqyEKWb4rjdXGg
```

# Kitaplıklar ve araçlar (Libraries and tools)
- [x] Navigation
- [x] MVVM
- [x] Retrofit & RxJava
- [x] Extensions
- [x] ROOM
- [x] Data Binding
- [x] View Binding

# NOT (NOTE):
Video süresi 72sn ve bu videoyu gif'e dönüştürdüğümde boyutu 19.4mb ve haliyle Github bunu kabul etmiyordu. Gif'in boyutunu düşürmek için kalitesini azalttım bundan ötürü biraz bulanık görünmekte.

<p align="center">
  <img width="300" height="500" src="https://user-images.githubusercontent.com/36104238/119580946-324eca80-bdca-11eb-9b23-90050219e55c.gif">
</p>

# [Navigation](https://developer.android.com/guide/navigation/navigation-getting-started) <br/>
📍 Navigation ile fragment'lar arasında geçiş yapmanın yanısıra bu uygulamada da istenilen geçiş esnasında animasyon ve argument ile birbiri arasında bundle ile değer gönderme imkanı da sağlanmakta. Bu değer açılacak olan fragment'in şekillenmesi ve hangi takımın bilgisine göre şekillenmesinde büyük rol oynamaktadır.

![image1](https://user-images.githubusercontent.com/36104238/119577099-a9806080-bdc2-11eb-948a-6c92dbbed90d.png)

![image2](https://user-images.githubusercontent.com/36104238/119577107-ae451480-bdc2-11eb-8ab2-b1bedfe9029c.png)

# [Navigation Animation](https://developer.android.com/guide/navigation/navigation-animate-transitions)

![image3](https://user-images.githubusercontent.com/36104238/119577111-b1400500-bdc2-11eb-9b57-8e060c4b873b.png)

![image4](https://user-images.githubusercontent.com/36104238/119577130-b735e600-bdc2-11eb-9732-4b9031609005.png)

# DATA BINDING
📍 Android uzun zamandır layout xml içerisinde bulunan gerek id değerlerine gereksede burda bulunan xml'in herhangi bir komutuna ulaşmakta hep zorluk yaşamaktadır. Bunun sebebi hafızayı çok azda olsa yormaktan. Daha önceden id 'kotlin-android-extensions'hazır bir şekilde gelmekteydi 

![android databinding use](https://user-images.githubusercontent.com/36104238/119585860-439cd480-bdd4-11eb-86e0-84483c2f039d.png)

[DataBinding](https://developer.android.com/topic/libraries/data-binding) ile artık xml içerisindeki id değerine erişmeksızın TextView için text içerisinde, ImageView için ise oluşurulan Extensions ile bu değerlere doğrudan erişip modelde tanımlı değerine doğrudan atama işlemi yapılabilmektedir. Bu işlem layout tag'i içerisinde tanımlanmalı

![image5](https://user-images.githubusercontent.com/36104238/119577146-bbfa9a00-bdc2-11eb-9ecc-9b0fc6fc459f.png)

![image6](https://user-images.githubusercontent.com/36104238/119577157-c157e480-bdc2-11eb-8be5-6ada9aae4e89.png)

![image7](https://user-images.githubusercontent.com/36104238/119577170-c5840200-bdc2-11eb-9fa4-4fbfb9d266f4.png)

![image8](https://user-images.githubusercontent.com/36104238/119577194-d0d72d80-bdc2-11eb-884a-74b0bc578173.png)

![image9](https://user-images.githubusercontent.com/36104238/119577201-d6cd0e80-bdc2-11eb-9150-43af2b0d9d35.png)

![image10](https://user-images.githubusercontent.com/36104238/119577206-d9c7ff00-bdc2-11eb-88ec-cad41afb3c41.png)

# [ROOM](https://developer.android.com/training/data-storage/room) <br/>
📍 [Jetpack](https://developer.android.com/jetpack)'in en önemli öğelerinden bir tanesi diyebiliriz, Özellikle Android 4.1 ile Android Studio içerisine eklenen Database Inspector ile gerek sorguların gereksede kodların clean bir şekilde yazılmasının yanısıra bu yazılın kodlar tıpkı [Download SQL Server Management Studio (SSMS)](https://docs.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver15) gibi bir arayüz ile SQL kodlarını  data anlaşılır kılmakta.

![image11](https://user-images.githubusercontent.com/36104238/119582840-07667580-bdce-11eb-8caf-9cbd5d4388bf.png)

📍 API'dan gelen verilerin önce [Model View ViewModel (MVVM)](https://developer.android.com/topic/libraries/architecture/viewmodel) ile kullanıcının görünmesine uygun hale geldikten sonra bu verileri ROOM'a kaydedilmesi se sağlandı. [Jetpack](https://developer.android.com/jetpack)'in getirdiği ayrılacalıklardan biri Kotlin veya Java kodları gerekmeksızın normal SQL sorgusu ile yazılmış iki örnek aşağıda verilmektedir


✔ Takım adında "real" bulunan takımların ligdeki sıralaması ve bu takımların adının SQL sorgusu.<br/>

✔ Ligde bulunan toplam takım sayısının SQL sorgusu<br/>

![image12](https://user-images.githubusercontent.com/36104238/119582852-0e8d8380-bdce-11eb-8f6b-a66b58d878ba.png)

# KAYNAKLAR (RESOURCES)
- [Developer Android Studio](https://developer.android.com/)
- [Stackoverflow](https://stackoverflow.com/)
- [Github](https://github.com/)
- [Medium](https://medium.com/)
