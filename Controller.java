package rest.java;
/*код создан программистом Petrolti, e-mail: petrov_ot@mail.ru*/
public class Controller {
    public static void main(String args[]){
        new Model("state=Самара");
        // координаты показывают географический центр выбранного региона, по данным Open Street Map
        // проверено на:
        // q=pfo,q=ПФО,q=ЦФО,q=СКФО,
        // state=samara,state=Самара,state=saratov,state=Саратов,state=moskau,state=Москва
            // есть проблема с пониманием русских названий, например "Самарская область" приводит к нулевому результату поиска
            // - пока не знаю как решить
        // вывод массива координат можно изменить - сейчас он в формате geojson (как есть), т.к.
            // в задании нет четкого указания на тип массива и/или образец вывода
    }
}