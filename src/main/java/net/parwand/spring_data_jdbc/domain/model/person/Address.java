package net.parwand.spring_data_jdbc.domain.model.person;

import org.springframework.data.relational.core.mapping.Table;

/**
 * @Author PAR ALS
 * //TODO @ONE_TO_ONE (PERSON -1-----1- ADDRESS)
 * // Person does not need to have an address ==> save personID in Address table, to avoid the null value in Person table
 */

@Table("ADDRESS")
public record Address(String street, int plz, String country) {
}
