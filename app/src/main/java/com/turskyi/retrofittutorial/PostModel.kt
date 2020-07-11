package com.turskyi.retrofittutorial

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PostModel {

    /**
     * @return The site
     */
    @SerializedName("site") @Expose var site: String? = null

    /**
     * @return The elementPureHtml
     */
    @SerializedName("elementPureHtml") @Expose var elementPureHtml: String? = null

}