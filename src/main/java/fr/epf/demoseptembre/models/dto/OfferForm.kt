package fr.epf.demoseptembre.models.dto;

import org.springframework.web.multipart.MultipartFile
import java.util.*
import javax.persistence.Entity

/**
 * Cette classe utilise Kotlin (parce qu'on est grave des Hipsters).
 * La "data class" représente un "POJO" (plain-old java object), c'est à dire un objet qui n'est destiné qu'à "représenter" une entité.
 * Ici, en l'occurence, un utilisateur.
 * @author Loïc Ortola on 10/09/2018
 */
data class OfferForm(var title: String? = null, var location: String?= null, var surface: Int?= null, var beds: Int?= null, var mpfile: MultipartFile?= null) {


    fun encoder(mpfile: MultipartFile): String{
        val byteArr = mpfile.getBytes()
        val base64 = Base64.getEncoder().encodeToString(byteArr)
        return base64
    }

}
