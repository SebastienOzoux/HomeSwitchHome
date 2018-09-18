package fr.epf.demoseptembre.models

import javassist.bytecode.ByteArray
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Lob

/**
 * Cette classe utilise Kotlin (parce qu'on est grave des Hipsters).
 * La "data class" représente un "POJO" (plain-old java object), c'est à dire un objet qui n'est destiné qu'à "représenter" une entité.
 * Ici, en l'occurence, un utilisateur.
 * @author Loïc Ortola on 10/09/2018
 */
@Entity
data class Offer(@Id @GeneratedValue var id: Int? =  null, var title: String? = null, var location: String?= null, var surface: Int?= null, var beds: Int?= null, var photo: String?= null) {
}