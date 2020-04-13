package pdt.client

import io.circe.generic.auto._
import pdt.client.HttpClient.{HttpClient, get}
import pdt.domain._
import pdt.implicits.HttpRequestOps
import zio.RIO

object Contratos {

  def by(request: ContratoRequest): RIO[HttpClient, List[ContratoPoderExecutivoFederal]] =
    get[ContratoPoderExecutivoFederal]("contratos", request.parameters)

  def by(id: Long): RIO[HttpClient, ContratoPoderExecutivoFederal] =
    get[ContratoPoderExecutivoFederal]("contratos", id)

  def by(request: NumeroContratoRequest): RIO[HttpClient, List[ContratoPoderExecutivoFederal]] =
    get[ContratoPoderExecutivoFederal]("contratos/numero", request.parameters)

  def apostilamento(id: Int): RIO[HttpClient, List[Apostilamento]] =
    get[Apostilamento]("contratos/apostilamento", Map("id" -> id.toString))

  def documentosRelacionados(id: Int): RIO[HttpClient, List[DocumentosRelacionados]] =
    get[DocumentosRelacionados]("contratos/documentos-relacionados", Map("id" -> id.toString))

  def termoAditivo(id: Int): RIO[HttpClient, List[TermoAditivo]] =
    get[TermoAditivo]("contratos/termo-aditivo", Map("id" -> id.toString))
}