# Desafio Fóton APOD Browser
Aplicação Nativa Android do desafio da Fóton

## Descrição de Funcionalidade
A aplicação, chamada APOD Browser, é uma aplicação que consome uma das APIs abertas pela NASA: APOD. APOD é um acrônimo para *Astronomical Picture of the Day*,
que é um website provido pela NASA e pela Michigan Technological University. Tudo o que a aplicação faz, é listar os APODs dos últimos 30 dias.

*Para mais informações sobre o APOD, consulte esses links:*
<p><a href="https://pt.wikipedia.org/wiki/Astronomy_Picture_of_the_Day">Astronomical Picture of the Day - Wikipédia</a></p>
<p><a href="https://apod.nasa.gov/apod/astropix.html">Astronomical Picture of the Day - Página oficial</a></p>

## Descrição técnica
A aplicação segue a implementação requirida no documento do desafio, com a implementação dos seguintes requisitos técnicos:
1. Arquitetura MVVM;
2. *Caching* do retorno da API (com isso a aplicação também funciona offline);
3. Componentes do Jetpack usados (ViewModel, LiveData, ViewBinding e Room);
4. Injeção de dependencias feita de forma manual;
5. Conceitos de Clean Architecture (Utilização de Fachadas, Humble Interfaces);
6. Princípios de S.O.L.I.D (Single Responsability Principle, Dependency Inversion);
7. Testes unitários da camada de domínio.

## Bibliotecas de terceiros utilizadas
1. Material Design;
2. ViewModel;
3. LiveData;
4. Swipe-Refresh layout;
5. Retrofit;
6. Kotlin Coroutines;
7. Room;
8. Glide;
9. Arch Core Testing;
10. Mockito.

*Para mais informações sobre as bibliotecas mencionadas acima, consulte os seguintes links:*
<p><a href="https://github.com/material-components">Material Design</a></p>
<p><a href="https://developer.android.com/topic/libraries/architecture/viewmodel">ViewModel</a></p>
<p><a href="https://developer.android.com/topic/libraries/architecture/livedata">LiveData</a></p>
<p><a href="https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout">Swipe-Refresh layout</a></p>
<p><a href="https://square.github.io/retrofit/">Retrofit</a></p>
<p><a href="https://developer.android.com/kotlin/coroutines">Kotlin Coroutines</a></p>
<p><a href="https://developer.android.com/training/data-storage/room/">Room</a></p>
<p><a href="https://github.com/bumptech/glide">Glide</a></p>
<p><a href="https://developer.android.com/jetpack/androidx/releases/arch-core">Arch Core Testing</a></p>
<p><a href="https://site.mockito.org">Mockito</a></p>
