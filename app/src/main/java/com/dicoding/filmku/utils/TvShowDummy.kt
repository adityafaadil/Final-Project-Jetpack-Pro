package com.dicoding.filmku.utils

import com.dicoding.filmku.data.source.local.entity.TvShow
import com.dicoding.filmku.data.source.remote.response.detail.DetailTvResults
import com.dicoding.filmku.data.source.remote.response.tv.ResultTvShow

object TvShowDummy {
    fun getTvShow(): List<TvShow> {
        return listOf(
            //tvShow 1
            TvShow(
                123123,
                "https://s4.bukalapak.com/uploads/content_attachment/9ef1d7fc30e8d7627da004c5/w-744/tv_series_terbaik_-1.jpg",
                "Secara garis besar, tv series ini berkisah tentang perebutan tahta kekuasaan diantara para keluarga. Bahkan mereka sampai mempertaruhkan nyawa untuk mendapatkan tahta yang mereka idam-idamkan. Jalan cerita yang kompleks, imajinasi cerita liar, dan eksekusi apik membuat tv series yang dibintangi oleh Emilia Clarke, Kit Harrington, Sophie Turner, dan Lena Headey ini pantas menerima predikat tv series terbaik.",
                "Tanggal rilis: 17/04/2011",
                "Game of Thrones"
            ),
            //tvShow 2
            TvShow(
                1231231,
                "https://s3.bukalapak.com/uploads/content_attachment/dc5b4c1320e8d76212b004c5/w-744/tv_series_terbaik_-2.jpg",
                "Breaking Bad menceritakan tentang seorang guru kimi bernama Walter White yang terjerumus ke dalam dunia narkoba setelah dinyatakan menderita kanker paru-paru. Alasan utama Walter White masuk ke bisnis barang haram tersebut adalah untuk mendapatkan banyak uang, sehingga ia bisa meninggalkan modal yang cukup untuk keluarganya jika suatu hari ia meninggal.",
                "Tanggal rilis: 20/01/2008",
                "Breaking Bad!"
            ),
            //tvShow 3
            TvShow(
                1231,
                "https://s4.bukalapak.com/uploads/content_attachment/96e7fdc420e8d76263b004c5/w-744/tv_series_terbaik_-3.jpg",
                "Tv series ini berkisah tentang dunia yang sudah hancur akibat merebaknya wabah zombie. Sehingga membuat sekelompok manusia harus bertahan hidup dengan susah payah sekaligus mempertahankan diri dari serangan zombie yang siap menerkam mereka kapan saja.",
                "Tanggal rilis: 31/10/2010",
                "The Walking Dead"
            ),
            //TvShow 4
            TvShow(
                12313132,
                "https://s2.bukalapak.com/uploads/content_attachment/2285ab5020e8d76254b004c5/w-744/tv_series_terbaik_-4.jpg",
                "Friends pertama kali tayang pada tahun 1994, dan sukses menjadi tv series yang melambungkan nama para pemerannya. Tv series ini dibintangi oleh Jennifer Aniston, Courtney Cox, Matthew Perry, dan Lisa Kudrow ini mengisahkan tentang sekelompok sahabat yang tinggal di daerah Manhattan, New York.",
                "Tanggal rilis: 22/09/1994",
                "Friends"
            ),
            //tvShow 5
            TvShow(
                123131,
                "https://s2.bukalapak.com/uploads/content_attachment/ce826c4d10e8d762cdb004c5/w-744/tv_series_terbaik_-11.jpg",
                "Stranger Things bercerita tentang seorang anak bernama Will Byers menghilang tanpa jejak. Sehingga membuat seluruh keluarganya kebingungan. Petualangan panjang yang dilakukan keluarga dan teman-teman Will dalam mencari dirinya pun tidak semudah yang dibayangkan. Banyak hal-hal seru yang menanti mereka.",
                "Tanggal rilis: 15/07/2016",
                "Stranger Things"
            )
        )
    }

    fun getTvShowDetail(): TvShow {
        return TvShow(
            123123,
            "https://s4.bukalapak.com/uploads/content_attachment/9ef1d7fc30e8d7627da004c5/w-744/tv_series_terbaik_-1.jpg",
            "Secara garis besar, tv series ini berkisah tentang perebutan tahta kekuasaan diantara para keluarga. Bahkan mereka sampai mempertaruhkan nyawa untuk mendapatkan tahta yang mereka idam-idamkan. Jalan cerita yang kompleks, imajinasi cerita liar, dan eksekusi apik membuat tv series yang dibintangi oleh Emilia Clarke, Kit Harrington, Sophie Turner, dan Lena Headey ini pantas menerima predikat tv series terbaik.",
            "Tanggal rilis: 17/04/2011",
            "Game of Thrones"
        )
    }

    fun getTvShowResponse(): List<ResultTvShow> {
        return listOf(
            ResultTvShow(
                123123,
                "https://s4.bukalapak.com/uploads/content_attachment/9ef1d7fc30e8d7627da004c5/w-744/tv_series_terbaik_-1.jpg",
                "Secara garis besar, tv series ini berkisah tentang perebutan tahta kekuasaan diantara para keluarga. Bahkan mereka sampai mempertaruhkan nyawa untuk mendapatkan tahta yang mereka idam-idamkan. Jalan cerita yang kompleks, imajinasi cerita liar, dan eksekusi apik membuat tv series yang dibintangi oleh Emilia Clarke, Kit Harrington, Sophie Turner, dan Lena Headey ini pantas menerima predikat tv series terbaik.",
                "Tanggal rilis: 17/04/2011",
                "Game of Thrones"
            ),
            ResultTvShow(
                1231231,
                "https://s3.bukalapak.com/uploads/content_attachment/dc5b4c1320e8d76212b004c5/w-744/tv_series_terbaik_-2.jpg",
                "Breaking Bad menceritakan tentang seorang guru kimi bernama Walter White yang terjerumus ke dalam dunia narkoba setelah dinyatakan menderita kanker paru-paru. Alasan utama Walter White masuk ke bisnis barang haram tersebut adalah untuk mendapatkan banyak uang, sehingga ia bisa meninggalkan modal yang cukup untuk keluarganya jika suatu hari ia meninggal.",
                "Tanggal rilis: 20/01/2008",
                "Breaking Bad!"
            ),
            ResultTvShow(
                1231,
                "https://s4.bukalapak.com/uploads/content_attachment/96e7fdc420e8d76263b004c5/w-744/tv_series_terbaik_-3.jpg",
                "Tv series ini berkisah tentang dunia yang sudah hancur akibat merebaknya wabah zombie. Sehingga membuat sekelompok manusia harus bertahan hidup dengan susah payah sekaligus mempertahankan diri dari serangan zombie yang siap menerkam mereka kapan saja.",
                "Tanggal rilis: 31/10/2010",
                "The Walking Dead"
            ),
            ResultTvShow(
                12313132,
                "https://s2.bukalapak.com/uploads/content_attachment/2285ab5020e8d76254b004c5/w-744/tv_series_terbaik_-4.jpg",
                "Friends pertama kali tayang pada tahun 1994, dan sukses menjadi tv series yang melambungkan nama para pemerannya. Tv series ini dibintangi oleh Jennifer Aniston, Courtney Cox, Matthew Perry, dan Lisa Kudrow ini mengisahkan tentang sekelompok sahabat yang tinggal di daerah Manhattan, New York.",
                "Tanggal rilis: 22/09/1994",
                "Friends"
            ),
            ResultTvShow(
                123131,
                "https://s2.bukalapak.com/uploads/content_attachment/ce826c4d10e8d762cdb004c5/w-744/tv_series_terbaik_-11.jpg",
                "Stranger Things bercerita tentang seorang anak bernama Will Byers menghilang tanpa jejak. Sehingga membuat seluruh keluarganya kebingungan. Petualangan panjang yang dilakukan keluarga dan teman-teman Will dalam mencari dirinya pun tidak semudah yang dibayangkan. Banyak hal-hal seru yang menanti mereka.",
                "Tanggal rilis: 15/07/2016",
                "Stranger Things"
            )
        )
    }

    fun getTvShowDetailResponse(): DetailTvResults{
        return DetailTvResults(
            123123,
            "https://s4.bukalapak.com/uploads/content_attachment/9ef1d7fc30e8d7627da004c5/w-744/tv_series_terbaik_-1.jpg",
            "Secara garis besar, tv series ini berkisah tentang perebutan tahta kekuasaan diantara para keluarga. Bahkan mereka sampai mempertaruhkan nyawa untuk mendapatkan tahta yang mereka idam-idamkan. Jalan cerita yang kompleks, imajinasi cerita liar, dan eksekusi apik membuat tv series yang dibintangi oleh Emilia Clarke, Kit Harrington, Sophie Turner, dan Lena Headey ini pantas menerima predikat tv series terbaik.",
            "Tanggal rilis: 17/04/2011",
            "Game of Thrones"
        )
    }
}