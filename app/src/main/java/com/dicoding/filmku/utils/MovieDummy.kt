package com.dicoding.filmku.utils


import com.dicoding.filmku.data.source.local.entity.Movie
import com.dicoding.filmku.data.source.remote.response.detail.DetailMovieResults
import com.dicoding.filmku.data.source.remote.response.movie.ResultMovie

object MovieDummy {
    fun getMovie(): List<Movie> {
        return listOf(
            //Movie 1
            Movie(
                213123,
                "https://variety.com/wp-content/uploads/2020/10/raya.jpg?w=1000",
                "Dahulu kala, di dunia fantasi Kumandra, manusia dan naga hidup bersama secara harmonis. Namun, ketika monster jahat yang dikenal sebagai Druun mengancam daratan, para naga mengorbankan diri mereka untuk menyelamatkan umat manusia. Sekarang, 500 tahun kemudian, monster yang sama telah kembali, dan seorang prajurit hadir untuk mencari naga terakhir dan menghentikan Druun untuk selamanya.",
                "Tanggal rilis: 18/07/2008",
                "Raya and The Last Dragon"
            ),
            //Movie 2
            Movie(
                123131,
                "https://www.99.co/blog/indonesia/wp-content/uploads/2020/10/film-action-lotr-return-of-king.jpeg",
                "Cerita dalam film 'The Lord of the Rings: The Return of the King' melanjutkan kisah dari film sebelumya. Frodo Baggins masih berjuang untuk menghancurkan cincin berkekuatan magis demi menyelamatkan dunia dari sang raja kegelapan Sauron. Frodo terpisah dari rombongan menuju Gunung Mordor bersama Sam.",
                "Tanggal rilis: 14/01/2003",
                "The Lord of the Rings: The Return of the King (2003)"
            ),
            //Movie 3
            Movie(
                12313,
                "https://variety.com/wp-content/uploads/2020/03/9-2.jpg?w=1000",
                "Morbius bercerita tentang Dr. Michael Morbius, seorang antihero Spider-Man klasik yang menjadi vampir saat berusaha menyembuhkan dirinya dari penyakit darah langka. Dibintangi oleh Jared Leto, film tersebut bakal menunjukkan beberapa koneksi dengan penjahat Spider-Man lainnya, yang mungkin mengisyaratkan persilangan besar.",
                "Tanggal rilis: 19/03/2021",
                "Morbius"
            ),
            //Movie 4
            Movie(
                123131,
                "https://variety.com/wp-content/uploads/2019/08/cruella.jpg?w=1024",
                "Berlatar belakang punk dan mode London tahun 1970-an, film live-action Disney ini akan memperkenalkan Emma Stone sebagai Cruella de Vil yang lebih muda, penjahat ikonik dari film 101 Dalmatians tahun 1961. Film ini juga akan dibintangi oleh Emma Thompson, Joel Fry Paul, Walter Hauser dan Mark Strong.",
                "Tanggal rilis: 28/05/2021",
                "Cruella"
            ),
            //movie 5
            Movie(
                12321313,
                "https://variety.com/wp-content/uploads/2020/03/no-time-james.jpg?w=1024",
                "Film yang dibintangi oleh Daniel Craig ini menceritakan kegagalan pengunduran diri James Bond di Jamaika ketika seorang teman lamanya, Felix Leiter (Jeffrey Wright), datang mencari bantuan.\n" +
                        "\n" +
                        "Nantinya Bond harus menyelesaikan misi menyelamatkan seorang ilmuwan yang diculik. Dalam proses penyelamatan itu, diketahui Bond akan bertemu dengan Safin (Rami Malek), penjahat bertopeng misterius yang dipersenjatai dengan teknologi berbahaya.",
                "Tanggal rilis: 02/04/2021",
                "No Time to Die"
            )
        )
    }

    fun getMovieDetail(): Movie {
        return Movie(
            213123,
            "https://variety.com/wp-content/uploads/2020/10/raya.jpg?w=1000",
            "Dahulu kala, di dunia fantasi Kumandra, manusia dan naga hidup bersama secara harmonis. Namun, ketika monster jahat yang dikenal sebagai Druun mengancam daratan, para naga mengorbankan diri mereka untuk menyelamatkan umat manusia. Sekarang, 500 tahun kemudian, monster yang sama telah kembali, dan seorang prajurit hadir untuk mencari naga terakhir dan menghentikan Druun untuk selamanya.",
            "Tanggal rilis: 18/07/2008",
            "Raya and The Last Dragon"
        )
    }

    fun getMoviesResponse(): List<ResultMovie> {
        return listOf(
            ResultMovie(
                213123,
                "https://variety.com/wp-content/uploads/2020/10/raya.jpg?w=1000",
                "Dahulu kala, di dunia fantasi Kumandra, manusia dan naga hidup bersama secara harmonis. Namun, ketika monster jahat yang dikenal sebagai Druun mengancam daratan, para naga mengorbankan diri mereka untuk menyelamatkan umat manusia. Sekarang, 500 tahun kemudian, monster yang sama telah kembali, dan seorang prajurit hadir untuk mencari naga terakhir dan menghentikan Druun untuk selamanya.",
                "Tanggal rilis: 18/07/2008",
                "Raya and The Last Dragon"
            ),
            ResultMovie(
                123131,
                "https://www.99.co/blog/indonesia/wp-content/uploads/2020/10/film-action-lotr-return-of-king.jpeg",
                "Cerita dalam film 'The Lord of the Rings: The Return of the King' melanjutkan kisah dari film sebelumya. Frodo Baggins masih berjuang untuk menghancurkan cincin berkekuatan magis demi menyelamatkan dunia dari sang raja kegelapan Sauron. Frodo terpisah dari rombongan menuju Gunung Mordor bersama Sam.",
                "Tanggal rilis: 14/01/2003",
                "The Lord of the Rings: The Return of the King (2003)"
            ),
            ResultMovie(
                12313,
                "https://variety.com/wp-content/uploads/2020/03/9-2.jpg?w=1000",
                "Morbius bercerita tentang Dr. Michael Morbius, seorang antihero Spider-Man klasik yang menjadi vampir saat berusaha menyembuhkan dirinya dari penyakit darah langka. Dibintangi oleh Jared Leto, film tersebut bakal menunjukkan beberapa koneksi dengan penjahat Spider-Man lainnya, yang mungkin mengisyaratkan persilangan besar.",
                "Tanggal rilis: 19/03/2021",
                "Morbius"
            ),
            ResultMovie(
                123131,
                "https://variety.com/wp-content/uploads/2019/08/cruella.jpg?w=1024",
                "Berlatar belakang punk dan mode London tahun 1970-an, film live-action Disney ini akan memperkenalkan Emma Stone sebagai Cruella de Vil yang lebih muda, penjahat ikonik dari film 101 Dalmatians tahun 1961. Film ini juga akan dibintangi oleh Emma Thompson, Joel Fry Paul, Walter Hauser dan Mark Strong.",
                "Tanggal rilis: 28/05/2021",
                "Cruella"
            ),
            ResultMovie(
                12321313,
                "https://variety.com/wp-content/uploads/2020/03/no-time-james.jpg?w=1024",
                "Film yang dibintangi oleh Daniel Craig ini menceritakan kegagalan pengunduran diri James Bond di Jamaika ketika seorang teman lamanya, Felix Leiter (Jeffrey Wright), datang mencari bantuan.\n" +
                        "\n" +
                        "Nantinya Bond harus menyelesaikan misi menyelamatkan seorang ilmuwan yang diculik. Dalam proses penyelamatan itu, diketahui Bond akan bertemu dengan Safin (Rami Malek), penjahat bertopeng misterius yang dipersenjatai dengan teknologi berbahaya.",
                "Tanggal rilis: 02/04/2021",
                "No Time to Die"
            )

        )
    }

    fun getMovieDetailResponse(): DetailMovieResults {
        return DetailMovieResults(
            213123,
            "https://variety.com/wp-content/uploads/2020/10/raya.jpg?w=1000",
            "Dahulu kala, di dunia fantasi Kumandra, manusia dan naga hidup bersama secara harmonis. Namun, ketika monster jahat yang dikenal sebagai Druun mengancam daratan, para naga mengorbankan diri mereka untuk menyelamatkan umat manusia. Sekarang, 500 tahun kemudian, monster yang sama telah kembali, dan seorang prajurit hadir untuk mencari naga terakhir dan menghentikan Druun untuk selamanya.",
            "Tanggal rilis: 18/07/2008",
            "Raya and The Last Dragon"
        )
    }
}