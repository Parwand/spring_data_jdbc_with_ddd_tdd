package net.parwand.spring_data_jdbc.infrastructure.dto;

import org.springframework.data.relational.core.mapping.Table;

@Table("ADDRESS")
public record AddressEntity(String street, int plz, String country) {
}
