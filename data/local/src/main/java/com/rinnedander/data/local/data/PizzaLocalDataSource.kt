package com.rinnedander.data.local.data

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import com.rinnedander.data.local.IPizzaLocalDataSource
import com.rinnedander.data.local.database.dao.IPizzaDao
import com.rinnedander.data.local.entities.PizzaEntity
import com.rinnedander.domain.model.Pizza

class PizzaLocalDataSource(
    private val dao: IPizzaDao
) : IPizzaLocalDataSource {

    override fun insert(pizza: Pizza): Completable =
        PizzaEntity.toEntity(pizza)
            .let(dao::insert)

    override fun insertAll(pizzaList: List<Pizza>): Completable =
        pizzaList.map(PizzaEntity.Companion::toEntity)
            .let(dao::insertAll)

    override fun get(id: Int): Flowable<Pizza> =
        dao.getById(id)
            .map(PizzaEntity::toPizza)

    override fun getAll(): Flowable<List<Pizza>> = Flowable.just(pizzaSet)
        //dao.getAll()
            //.map(PizzaEntity::toPizzaList)

    override fun search(query: String): Flowable<List<Pizza>> =
        dao.search(query)
            .map(PizzaEntity::toPizzaList)
}

val pizzaSet = listOf(
    Pizza(
        id = 0,
        name = "Margarita",
        description = "Pizza Margherita (more commonly known in English as Margherita pizza) is a typical Neapolitan pizza, made with San Marzano tomatoes, mozzarella cheese, fresh basil, salt, and extra-virgin olive oil.",
        imageUrls = listOf("https://static.1000.menu/img/content-v2/ef/27/10853/picca-margarita-v-domashnix-usloviyax_1608783820_4_max.jpg"),
        price = 799.0
    ),
    Pizza(
        id = 1,
        name = "Detroit",
        description = "Reflecting the city’s deep ties to the auto industry, Detroit-style pizza was originally baked in a square automotive parts pan in the 1940’s. Detroit pizza is first topped with pepperoni, followed by brick cheese which is spread to the very edges of the pan, yielding a caramelized cheese perimeter. Sauce is then spooned over the pizza, an order similar to Chicago-style pizza. This pizza features a thick, extra crispy crust that is tender and airy on the inside.",
        imageUrls = listOf("https://cdnimg.webstaurantstore.com/uploads/blog/2019/3/blog-types-pizza_in-blog-7.jpg"),
        price = 999.0
    ),
    Pizza(
        id = 2,
        name = "Greek Pizza",
        description = "Greek pizza was created by Greek immigrants who came to America and were introduced to Italian pizza. Greek-style pizza, especially popular in the New England states, features a thick and chewy crust cooked in shallow, oiled pans, resulting in a nearly deep-fried bottom. While this style has a crust that is puffier and chewier than thin crust pizzas, it’s not quite as thick as a deep-dish or Sicilian crust.",
        imageUrls = listOf("https://cdnimg.webstaurantstore.com/uploads/blog/2016/8/onions.jpg"),
        price = 699.0
    ),
    Pizza(
        id = 3,
        name = "New York-Style Pizza",
        description = "With its characteristic large, foldable slices and crispy outer crust, New York-style pizza is one of America’s most famous regional pizza types. Originally a variation of Neapolitan-style pizza, the New York slice has taken on a fame all its own, with some saying its unique flavor has to do with the minerals present in New York’s tap water supply.",
        listOf("https://cdnimg.webstaurantstore.com/uploads/blog/2016/8/flat.jpg"),
        price = 560.0
    ),
    Pizza(
        id = 4,
        name = "California",
        description = "California pizza, or gourmet pizza, is known for its unusual ingredients. This pizza got its start back in the late 1970’s when Chef Ed LaDou began experimenting with pizza recipes in the classic Italian restaurant, Prego. He created a pizza with mustard, ricotta, pate, and red pepper, and by chance, served it to Wolfgang Puck. Impressed with LaDou’s innovative pie, Puck invited him to be a head pizza chef at his restaurant. It was here that LaDou came up with over 250 unique pizza recipes that eventually formed the menu of the chain restaurant California Pizza Kitchen.",
        imageUrls = listOf("https://cdnimg.webstaurantstore.com/uploads/buying_guide/2014/11/pizzatypes-gourmet.jpg"),
        price = 910.0
    ),
    Pizza(
        id = 5,
        name = "Chicago",
        description = "Chicago pizza, also commonly referred to as deep-dish pizza, gets its name from the city it was invented in. During the early 1900’s, Italian immigrants in the windy city were searching for something similar to the Neapolitan pizza that they knew and loved. Instead of imitating the notoriously thin pie, Ike Sewell had something else in mind. He created a pizza with a thick crust that had raised edges, similar to a pie, and ingredients in reverse, with slices of mozzarella lining the dough followed by meat, vegetables, and then topped with a can of crushed tomatoes. This original creation led Sewell to create the now famous chain restaurant, Pizzeria Uno.",
        imageUrls = listOf("https://cdnimg.webstaurantstore.com/uploads/buying_guide/2014/11/pizzatypes-deepdish.jpg"),
        price = 460.0
    )
)