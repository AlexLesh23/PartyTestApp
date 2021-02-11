package com.bsc.msc.testapp

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

fun Disposable.addToCompositeDisposable(disposeBag: CompositeDisposable) {
    disposeBag.add(this)
}