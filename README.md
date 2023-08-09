# 🚩 API Gateway

<b> API Gateway, mikroservis tabanlı bir uygulama veya hizmet mimarisinde, gelen istekleri merkezi bir noktada yöneten ve mikroservisler arasındaki iletişimi kolaylaştıran bir bileşendir. Genellikle birden fazla mikroservisin yer aldığı karmaşık uygulamalarda kullanılır. API Gateway, istemcilerin tek bir noktadan servislere erişmelerini sağlayarak uygulamanın ölçeklenebilirliğini artırırken, güvenlik, kimlik doğrulama, yük dengeleme ve istekleri yönlendirme gibi işlevleri de üstlenir. </b>

## 🎯 **API Gateway Ne İşe Yarar?**

API Gateway şu temel işlevleri yerine getirir:

1. **Yönlendirme ve Yük Dengeleme:** API Gateway, gelen istekleri farklı mikroservislere yönlendirir ve yükü dengeler. Bu sayede her servis eşit bir şekilde kullanılır ve performans artar.
2. **Güvenlik ve Yetkilendirme:** API Gateway, istemcileri dışarıya karşı korur. Güvenlik denetimleri ve yetkilendirme mekanizmaları uygular. İstemcilerin sadece yetkili kullanıcılar tarafından kullanılmasını sağlar.
3. **İstek Dönüşümü ve Veri Formatı Dönüşümü:** Farklı istemciler farklı veri formatlarını tercih edebilir. API Gateway, istemcinin tercih ettiği veri formatına çevirme işlevini üstlenebilir.
4. **CORS Kontrolü:** API Gateway, farklı etki alanlarından gelen isteklerin güvenli bir şekilde kabul edilmesini sağlamak için Cross-Origin Resource Sharing (CORS) politikalarını uygular.
5. **Caching:** Sıkça talep edilen verileri önbelleğe alabilir. Bu sayede tekrarlayan istekler daha hızlı bir şekilde cevaplanır.
6. **Protokol Dönüşümü:** İstemci ile mikroservis arasında farklı iletişim protokolleri kullanılabilir. API Gateway, bu protokol dönüşümlerini sağlar.
7. **Hata Yönetimi:** Hata durumlarına karşı merkezi bir noktadan yönetim sağlar ve istemcilere anlamlı hata mesajları döndürebilir.
8. **API Dökümantasyonu:** API Gateway, mevcut mikroservislerin API'larını belgelendirerek istemcilere daha anlaşılır bir şekilde nasıl kullanılacağını sunar.


API Gateway, mikroservis mimarilerinin karmaşıklığını azaltarak, servislerin merkezi bir noktadan yönetilmesini ve entegrasyonun kolaylaştırılmasını sağlar. Bu sayede uygulamanın ölçeklenmesi, güvenliği ve performansı daha iyi yönetilebilir.


## 🎯 **Spring Boot ile API Gateway Kullanımı**

Spring Cloud Gateway, Spring tabanlı mikroservis uygulamaları için kullanılan bir API Gateway çözümüdür. İşte Spring Boot ile API Gateway kullanımının adımları:

### :large_blue_diamond: **Proje Oluşturma:**

İlk adım olarak, yeni bir Spring Boot projesi oluşturmanız gerekecek. Maven veya Gradle gibi bir bağımlılık yönetimi aracı kullanarak projenizi oluşturabilirsiniz.

1. :small_blue_diamond: **Bağımlılıkları Ekleyin:**

   Spring Cloud Gateway'ı kullanmak için **`pom.xml`** dosyanıza ilgili bağımlılıkları eklemelisiniz:
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
```
2. :small_blue_diamond:  **YKonfigürasyonlar:**

   API yönlendirmelerini ve diğer yapılandırmaları **`application.yml`** veya **`application.properties`** dosyasında yapılandırabilirsiniz. Örneğin:
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: user-service-route
          uri: http://user-service:8082
          predicates:
            - Path=/users/**
        - id: note-service-route
          uri: http://note-service:8083
          predicates:
            - Path=/notes/**
```

Burada **`user-service`** ve **`note-service`** mikroservislerine yönlendirmeleri tanımladık.

3. :small_blue_diamond: **Başlatma Sınıfı:**

   Başlatma sınıfında **`@EnableEurekaClient`** veya **`@EnableDiscoveryClient`** gibi etiketleri kullanarak Eureka veya diğer hizmet keşif araçlarına katılabilirsiniz. Ayrıca **`@SpringBootApplication`** etiketini unutmamanız gerekiyor.

4.  :small_blue_diamond: **API Gateway Kullanımı:**

   API Gateway, istemcilerin gelen isteklerini yönlendirir ve bu istekleri farklı mikroservislere dağıtır. Örneğin, **`/users`** isteği **`user-service`**'e, **`/notes`** isteği ise **`note-service`**'e yönlendirilir.


API Gateway, mikroservis mimarilerinde trafiği düzenlemek, güvenlik katmanını yönetmek ve mikroservisler arasında iletişimi kolaylaştırmak için önemli bir bileşendir. Spring Cloud Gateway gibi araçlar, bu işlevleri kolayca yerine getirmenizi sağlar. Bu sayede hem uygulamanızı ölçeklendirebilir hem de daha düzenli bir yapı oluşturabilirsiniz.


:pushpin: **Projeye Genel Bakış**

![](/images/3.png)