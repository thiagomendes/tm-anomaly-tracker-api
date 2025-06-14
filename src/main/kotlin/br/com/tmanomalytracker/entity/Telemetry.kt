package br.com.tmanomalytracker.entity

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.time.LocalDateTime

@Entity
@Schema(description = "A entidade Telemetry representa um registro de telemetria contendo informações sobre uma métrica específica em um determinado momento.")
data class Telemetry(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:Schema(
        description = "ID da Telemetria",
        example = "1",
    )
    val id: Long = 0,

    @field:Schema(
        description = "Nome da Métrica",
        example = "Volume de Vendas",
    )
    val metricName: String,

    @field:Schema(
        description = "Valor da Métrica",
        example = "150.0",
    )
    val value: Double,

    @field:Schema(
        description = "Data e hora em que a Telemetria foi registrada",
        example = "2023-06-22T12:00:00",
    )
    val timestamp: LocalDateTime = LocalDateTime.now(),

    @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
    var params: MutableList<TelemetryParam>? = ArrayList(),
)
