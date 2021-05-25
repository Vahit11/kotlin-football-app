package com.vahitkeskin.kotlinfootballapp.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.vahitkeskin.kotlinfootballapp.model.Model
import com.vahitkeskin.kotlinfootballapp.service.FootballAPIService
import com.vahitkeskin.kotlinfootballapp.roomdb.FootballDatabase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class TeamsViewModel(application: Application) : BaseViewModel(application) {

    private val footballAPIService = FootballAPIService()
    val teams = MutableLiveData<List<Model>>()
    private val disposable = CompositeDisposable()

    fun getDataScoreStatusAPI() {
        disposable.add(
            footballAPIService.getService()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Model>>() {
                    override fun onSuccess(t: List<Model>) {
                        storeInSQLite(t)
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }
    private fun showFootballs(footballList: List<Model>) {
        teams.value = footballList
    }

    private fun storeInSQLite(list: List<Model>) {
        launch {
            val dao = FootballDatabase(getApplication()).footballDao()
            dao.deleteAllFootballs()
            dao.insertAll(*list.toTypedArray())
            showFootballs(list)
        }
    }
}