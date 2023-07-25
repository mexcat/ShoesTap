package cl.gencina.shoestap

import cl.gencina.shoestap.modelo.Shoes

class InfoProductos {

    fun returnShoeList(): List<Shoes> {
        val shoeList = mutableListOf<Shoes>()
        val shoeItem1 = Shoes(0,"Zapato 1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQKXgFgJgTJjVFFpKVoVtrsMI6W-S4gAmxig&usqp=CAU", 99.99)
        shoeList.add(shoeItem1)
        val shoeItem2 = Shoes(1,"Zapato 2", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgvzFmYBNil92qGxRAhuNSPeRdd2kWdNBSquBB_jbtKtwvINvB2EwoXapbunYz3QtYCpY&usqp=CAU", 79.99)
        shoeList.add(shoeItem2)
        val shoeItem3 = Shoes(2,"Zapato 3", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2Y7BQbaSdNXVm1UAEtv7apzuAdEPySJgNYA&usqp=CAU", 149.99)
        shoeList.add(shoeItem3)
        val shoeItem4 = Shoes(3,"Zapato 4", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9xcHLHtoyCg1F0zWXWUkRS6N5l8QLHdhjEg&usqp=CAU", 129.99)
        shoeList.add(shoeItem4)
        val shoeItem5 = Shoes(4,"Zapato 5", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeFYIjbePLWCVO9Q-eDOT3QdlcXBQX7uPNRg&usqp=CAU", 109.99)
        shoeList.add(shoeItem5)
        val shoeItem6 = Shoes(5,"Zapato 6", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9LsCEGeYhXIpCLoahhonb39Ed28WDwhVW4Q&usqp=CAU", 89.99)
        shoeList.add(shoeItem6)
        val shoeItem7 = Shoes(6,"Zapato 7", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRz2DRHeYlrsF79845bJzxM6A595OHoU4IHOGlHa3eAWvEUo-NvGZ24HwP379jAK3_zMUs&usqp=CAU", 199.99)
        shoeList.add(shoeItem7)
        val shoeItem8 = Shoes(7,"Zapato 8", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmRAnK6ty8iscKiX9Q0qx7doaX_zxD-quyxX1SQLZP9VS1yU0CX2NpSvryfzwh4ICoDMQ&usqp=CAU", 169.99)
        shoeList.add(shoeItem8)
        val shoeItem9 = Shoes(8,"Zapato 9", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTH9aKZGXD-9XoBeiQi3iMtOATlPyYAMclJ-w&usqp=CAU", 119.99)
        shoeList.add(shoeItem9)
        val shoeItem10 = Shoes(9,"Zapato 10", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKQUBGb8Yz0MjZ0idUfnzF-b17P1vKZgyXMQ&usqp=CAU", 149.99)
        shoeList.add(shoeItem10)
        return shoeList
    }

    fun getShoe(id: Int):Shoes{
        val shoeList = returnShoeList()
        return shoeList[id]
    }

}