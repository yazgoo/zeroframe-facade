# zeroframe-facade


```scala
import org.scalajs.dom
import dom.document
import scala.scalajs.js
import io.github.yazgoo.zeroframe._

class Page extends ZeroFrame {

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }
  
  def setSiteInfo(siteInfo: SiteInfo) = {
    val out = document.getElementById("out")
    val dateTime = LocalDateTime.ofEpochSecond(siteInfo.content.modified.toLong, 0, ZoneOffset.UTC)
    out.innerHTML = 
      s"""- Page address: ${siteInfo.address}
      <br>- Peers: ${siteInfo.peers}
      <br>- Size: ${siteInfo.settings.size}
      <br>- Modified: ${dateTime}"""
  }
  def onOpenWebsocket() = {
    cmd("siteInfo", List(), setSiteInfo)
  }
  def onRequest(cmd: String, message: Message) = {
    if (cmd == "setSiteInfo") {
      setSiteInfo(message.params)
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    new Page()
  }
}
```
