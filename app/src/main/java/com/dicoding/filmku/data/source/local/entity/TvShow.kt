package com.dicoding.filmku.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "tvShow_data")
data class TvShow(

        @PrimaryKey
        @NotNull
        @ColumnInfo(name = "id")
        val showId: Int?,

        @ColumnInfo( name = "title")
        val title: String?,

        @ColumnInfo(name = "overview")
        val overview: String?,

        @ColumnInfo(name = "first_air_date")
        val firstAirDate: String?,

        @ColumnInfo(name = "poster_path")
        val imagePath: String?,

        @ColumnInfo(name = "favorite")
        var favorite: Boolean = false
)
