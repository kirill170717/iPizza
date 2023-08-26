package com.rinnedander.data.remote.data

import io.reactivex.rxjava3.core.Single
import com.rinnedander.data.remote.IPizzaRemoteDataSource
import com.rinnedander.data.remote.bodies.pizza.PizzaBody
import com.rinnedander.data.remote.client.pizza.IPizzaClient
import com.rinnedander.domain.model.Pizza

class PizzaRemoteDataSource(
    private val client: IPizzaClient
) : IPizzaRemoteDataSource {

    override fun getAll(): Single<List<Pizza>> = Single.just(pizzaSet)
        //client.getAll().map { pizzaList ->
            //pizzaList.map(PizzaBody::toPizza)
        //}

    override fun get(id: Int): Single<Pizza> = Single.just(pizzaSet[id])
        //client.getById(id).map(PizzaBody::toPizza)
}

val pizzaSet = listOf(
    Pizza(
        id = 0,
        name = "Margarita",
        description = "Pizza Margherita (more commonly known in English as Margherita pizza) is a " +
                "typical Neapolitan pizza, made with San Marzano tomatoes, mozzarella cheese, fresh " +
                "basil, salt, and extra-virgin olive oil.",
        imageUrls = listOf(
            "https://avatars.mds.yandex.net/get-altay/4660612/2a0000017b07abc817890e3f5afef5127cc3/XXL",
            "https://rumyancev.ru/image/catalog/margarita_1200x800px.jpg",
            "https://panda-nk.ru/upload/iblock/993/9932e7fab4c96341d2c705c16620c0ec.jpg"),
        price = 799.0
    ),
    Pizza(
        id = 1,
        name = "Detroit",
        description = "Reflecting the city’s deep ties to the auto industry, Detroit-style pizza " +
                "was originally baked in a square automotive parts pan in the 1940’s. " +
                "Detroit pizza is first topped with pepperoni, followed by brick cheese which is " +
                "spread to the very edges of the pan, yielding a caramelized cheese perimeter. " +
                "Sauce is then spooned over the pizza, an order similar to Chicago-style pizza. " +
                "This pizza features a thick, extra crispy crust that is tender and airy on the inside.",
        imageUrls = listOf(
            "https://grandecheese-wp.s3.amazonaws.com/wp-content/uploads/2020/04/21174350/detroit-style-pizza.jpg",
            "https://ww1.prweb.com/prfiles/2012/05/09/9466531/IMG_0329.JPG",
            "https://i.pinimg.com/originals/27/17/f8/2717f8c8fbf8adc40cff2eb81edf13da.jpg"),
        price = 999.0
    ),
    Pizza(
        id = 2,
        name = "Greek Pizza",
        description = "Greek pizza was created by Greek immigrants who came to America and were " +
                "introduced to Italian pizza. Greek-style pizza, especially popular in the New England " +
                "states, features a thick and chewy crust cooked in shallow, oiled pans, resulting " +
                "in a nearly deep-fried bottom. While this style has a crust that is puffier and " +
                "chewier than thin crust pizzas, it’s not quite as thick as a deep-dish or Sicilian crust.",
        imageUrls = listOf(
            "https://sun9-47.userapi.com/BCh8BHGu80rxNtkfX7mWogmJ_H_0CFV4PcDK8w/NwE_HFmMWd4.jpg",
            "https://cdn.bellinigroup.ru/upload/201912/5df9eb8c1bed5_1080x1080_fit_70_1c1c1e.png",
            "https://pizzasorento.ru/image/murom/menu/pitstsa/grecheskaya/upload/d020f778c244e5558d5084a23dc2616cc018e26e.jpg"),
        price = 699.0
    ),
    Pizza(
        id = 3,
        name = "New York-Style Pizza",
        description = "With its characteristic large, foldable slices and crispy outer crust, " +
                "New York-style pizza is one of America’s most famous regional pizza types. " +
                "Originally a variation of Neapolitan-style pizza, the New York slice has taken " +
                "on a fame all its own, with some saying its unique flavor has to do with the " +
                "minerals present in New York’s tap water supply.",
        listOf(
            "https://avatars.mds.yandex.net/get-mpic/5313128/img_id2494745313654269886.jpeg/9",
            "https://media.timeout.com/images/106007465/image.jpg",
            "https://avatars.mds.yandex.net/get-altay/2701558/2a00000171ecb71051f8a823c578794ec72c/XXL"),
        price = 560.0
    ),
    Pizza(
        id = 4,
        name = "California",
        description = "California pizza, or gourmet pizza, is known for its unusual ingredients. " +
                "This pizza got its start back in the late 1970’s when Chef Ed LaDou began " +
                "experimenting with pizza recipes in the classic Italian restaurant, Prego. " +
                "He created a pizza with mustard, ricotta, pate, and red pepper, and by chance, " +
                "served it to Wolfgang Puck. Impressed with LaDou’s innovative pie, Puck invited him " +
                "to be a head pizza chef at his restaurant. It was here that LaDou came up with over " +
                "250 unique pizza recipes that eventually formed the menu of the chain restaurant California Pizza Kitchen.",
        imageUrls = listOf(
            "https://funbest.ru/uploads/posts/2022-04/1649053845_wi22rlzesw0.jpg",
            "https://canadacook.ru/recipe_photo/2016-07-26/picca-kaliforniya_1469553405.jpg",
            "https://www.laparent.com/wp-content/uploads/2017/10/The-Original-BBQ-Chicken-Pizza_August-2016.jpeg"),
        price = 910.0
    ),
    Pizza(
        id = 5,
        name = "Chicago",
        description = "Chicago pizza, also commonly referred to as deep-dish pizza, gets its name " +
                "from the city it was invented in. During the early 1900’s, Italian immigrants in " +
                "the windy city were searching for something similar to the Neapolitan pizza that " +
                "they knew and loved. Instead of imitating the notoriously thin pie, Ike Sewell " +
                "had something else in mind. He created a pizza with a thick crust that had raised " +
                "edges, similar to a pie, and ingredients in reverse, with slices of mozzarella " +
                "lining the dough followed by meat, vegetables, and then topped with a can of crushed " +
                "tomatoes. This original creation led Sewell to create the now famous chain restaurant, Pizzeria Uno.",
        imageUrls = listOf(
            "https://slice-menu-assets-prod.imgix.net/5895/1582825844_de1c171211",
            "https://пиццашкола.рф/wp-content/uploads/2022/04/Американская-пицца-Чикагская.jpg",
            "https://i.pinimg.com/originals/38/7c/f0/387cf04e4a9b3e4d73bd0bebb82a4228.jpg"),
        price = 460.0
    )
)