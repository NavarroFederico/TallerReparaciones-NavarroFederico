import com.example.tallerreparaciones_navarrofederico.entities.Repair

import java.time.LocalDate
import java.time.Month

object RepairRepository {

    private var repairs: MutableList<Repair> = mutableListOf()

    init {
        // mutableMapOf(sparePartCode to unitsUsed, ...)
        val sparePartsUsedIn1 = mutableMapOf(1 to 1, 2 to 2)
        val sparePartsUsedIn3 = mutableMapOf(2 to 1, 3 to 1)
        val sparePartsUsedIn4 = mutableMapOf(3 to 1)
        val sparePartsUsedIn2 = mutableMapOf(2 to 2)
        val sparePartsUsedIn5 = mutableMapOf(2 to 1)
        val sparePartsUsedIn6 = mutableMapOf(1 to 1, 2 to 2, 4 to 1)
        val sparePartsUsedIn7 = mutableMapOf(1 to 1, 2 to 4)

        // Repair(code, clientCode, completionDate, sparePartsUsed, hoursWorked)
        repairs.add(Repair(1, 1, LocalDate.of(2021, Month.APRIL, 15), sparePartsUsedIn1, 10))
        repairs.add(Repair(2, 3, LocalDate.of(2021, Month.APRIL, 20), sparePartsUsedIn2, 8))
        repairs.add(Repair(3, 1, LocalDate.of(2021, Month.APRIL, 21), sparePartsUsedIn3, 5))
        repairs.add(Repair(4, 2, LocalDate.of(2021, Month.MAY, 5), sparePartsUsedIn4, 1))
        repairs.add(Repair(5, 3, LocalDate.of(2021, Month.MAY, 10), sparePartsUsedIn5, 3))
        repairs.add(Repair(6, 4, LocalDate.of(2021, Month.MAY, 12), sparePartsUsedIn6, 3))
        repairs.add(Repair(7, 3, LocalDate.of(2021, Month.MAY, 16), sparePartsUsedIn7, 5))
    }

    fun getByCodeRepair(code: Int): Repair? {
        for (repair in repairs) {
            if (repair.code == code)
                return repair
        }
        return null
    }

   /*  fun getByClientCode(clientCode: Int) :Repair? {
         for (repair in repairs){
             if(repair.clientCode == clientCode)
                 return repair
         }
         return null
     }*/


    fun getAllRepairByClientCode(clientCode :Int):List<Repair>{
        val repairsFilterByClientCode= repairs.filter {it.clientCode == clientCode  }
        return repairsFilterByClientCode


    }

    fun searchRepairByMonth_Year_ClientCode(month: Month, year: Int, clientCode: Int): List<Repair> {
        val filterList = repairs.filter { it.completionDate.month.equals(month) && it.completionDate.year == year && it.clientCode==clientCode}
        return filterList
    }

    fun get(): MutableList<Repair> {
        return repairs
    }
}
