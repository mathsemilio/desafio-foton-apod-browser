# Desafio Fóton APOD Browser
Aplicação Nativa Android do desafio da Fóton.

## Descrição de Funcionalidade
A aplicação, chamada APOD Browser, é uma aplicação que consome uma das APIs abertas pela NASA: APOD API. 
[APOD](https://pt.wikipedia.org/wiki/Astronomy_Picture_of_the_Day) é um acrônimo para *Astronomical Picture of the Day*,
que é um [website](https://apod.nasa.gov/apod/astropix.html) provido pela NASA e pela Michigan Technological University.
Tudo o que a aplicação faz, é listar os APODs dos últimos 30 dias.

## Descrição técnica
A aplicação segue a implementação requirida no documento do desafio, com a implementação dos seguintes requisitos técnicos:
1. Arquitetura MVVM;
2. *Caching* do retorno da API (com isso a aplicação também funciona offline);
3. Componentes do Jetpack usados (ViewModel, LiveData, ViewBinding e Room);
4. Injeção de dependencias feita de forma manual;
5. Conceitos de Clean Architecture (Utilização de Fachadas, Humble Interfaces);
6. Princípios de S.O.L.I.D (Single Responsability Principle, Dependency Inversion);
7. Teste unitário da ViewModel da tela de lista de APODs.

## Bibliotecas de terceiros utilizadas
1. <a href="https://github.com/material-components">Material Design</a>;
2. <a href="https://developer.android.com/topic/libraries/architecture/viewmodel">ViewModel</a>;
3. <a href="https://developer.android.com/topic/libraries/architecture/livedata">LiveData</a>;
4. <a href="https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout">Swipe-Refresh layout</a>;
5. <a href="https://square.github.io/retrofit/">Retrofit</a>;
6. <a href="https://developer.android.com/kotlin/coroutines">Kotlin Coroutines</a>;
7. <a href="https://developer.android.com/training/data-storage/room/">Room</a>;
8. <a href="https://github.com/bumptech/glide">Glide</a>;
9. <a href="https://developer.android.com/jetpack/androidx/releases/arch-core">Arch Core Testing</a>;
10. <a href="https://site.mockito.org">Mockito</a>.
