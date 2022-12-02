package com.justforentrepreneurs.j4eapp

import io.reactivex.disposables.CompositeDisposable

interface Base {
    val disposables:CompositeDisposable
}