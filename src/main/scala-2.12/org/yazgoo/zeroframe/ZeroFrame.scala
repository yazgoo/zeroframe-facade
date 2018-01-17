package org.yazgoo.zeroframe

import scala.scalajs.js
import scala.scalajs.js.annotation._
@js.native
trait Content extends js.Object {
    def modified: Int = js.native
}

@js.native
trait Settings extends js.Object {
    def size: Int = js.native
}

@js.native
trait SiteInfo extends js.Object {
    def address: String = js.native
    def peers: Int = js.native
    def content: Content = js.native
    def settings: Settings = js.native
} 

@js.native
trait Message extends js.Object {
    def params: SiteInfo = js.native
}

@js.native
@JSGlobal
class ZeroFrame extends js.Object {
    def cmd(action: String, params: List[js.Object], f: js.Function1[SiteInfo, Unit]): Unit = js.native
}

