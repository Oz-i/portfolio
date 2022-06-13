# portfolio
<h3>REST API for Library</h3>
<p>Aplikacja posiada zamodelowane encje i związane z nimi tabele:<ul>
<li>	czytelników, która zawiera id czytelnika, imię, nazwisko i datę założenia konta,</li>
<li>	tytułów, która zawiera id tytułu, tytuł, autora i rok wydania,</li>
<li>	egzemplarzy książek, która zawiera id egzemplarza, id tytułu oraz status (np. w obiegu, zniszczona, zagubiona),</li>
<li>	wypożyczeń, która zawiera id egzemplarza, id czytelnika, datę wypożyczenia i datę zwrotu.</li></ul>
<p>Jeśli w zasobach biblioteki jest 5 książek "Ania z Zielonego Wzgórza", to w tabelach znajdzie się jedna pozycja w tabeli tytułów oraz 5 pozycji w tabeli egzemplarzy. 
Dzięki temu każda sztuka jest identyfikowalna w bazie, ale bez powielania informacji takich jak tytuł czy autor.
Oprócz tabel utworzone są uslugi REST. Podstawowe usługi to:<ul>
<li>	dodanie czytelnika,</li>
<li>	dodanie tytułu,</li>
<li>	dodanie egzemplarza,</li>
<li> zmiana statusu egzemplarza,</li>
<li>sprawdzenie ilości egzemplarzy danego tytułu dostępnych do wypożyczenia,</li>
<li>wypożyczenie książki,</li>
<li>zwrot książki (książka zgubiona równa się zapłaceniu kary, a książka wraca do puli książek zwróconych).</li>
</ul></p>

