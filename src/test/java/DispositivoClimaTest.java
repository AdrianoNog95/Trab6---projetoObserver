import org.ProjetoObserver.DispositivoClima;
import org.ProjetoObserver.EstacaoMeteorologica;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DispositivoClimaTest {

    @Test
    void deveNotificarUmDispositivo() {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica();
        DispositivoClima dispositivo = new DispositivoClima("Dispositivo 1");
        dispositivo.registrar(estacao);
        estacao.atualizarMedicoes(25.0f, 60.0f);
        assertEquals("Dispositivo 1, nova atualização de clima disponível: EstacaoMeteorologica{temperatura=25.0, umidade=60.0}", dispositivo.getUltimaNotificacao());
    }

    @Test
    void deveNotificarDispositivos() {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica();
        DispositivoClima dispositivo1 = new DispositivoClima("Dispositivo 1");
        DispositivoClima dispositivo2 = new DispositivoClima("Dispositivo 2");
        dispositivo1.registrar(estacao);
        dispositivo2.registrar(estacao);
        estacao.atualizarMedicoes(22.5f, 55.0f);
        assertEquals("Dispositivo 1, nova atualização de clima disponível: EstacaoMeteorologica{temperatura=22.5, umidade=55.0}", dispositivo1.getUltimaNotificacao());
        assertEquals("Dispositivo 2, nova atualização de clima disponível: EstacaoMeteorologica{temperatura=22.5, umidade=55.0}", dispositivo2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarDispositivo() {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica();
        DispositivoClima dispositivo = new DispositivoClima("Dispositivo 1");
        estacao.atualizarMedicoes(20.0f, 50.0f);
        assertNull(dispositivo.getUltimaNotificacao());
    }

    @Test
    void deveNotificarDispositivoEspecifico() {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica();
        DispositivoClima dispositivo1 = new DispositivoClima("Dispositivo 1");
        DispositivoClima dispositivo2 = new DispositivoClima("Dispositivo 2");
        dispositivo1.registrar(estacao);
        estacao.atualizarMedicoes(18.0f, 70.0f);
        assertEquals("Dispositivo 1, nova atualização de clima disponível: EstacaoMeteorologica{temperatura=18.0, umidade=70.0}", dispositivo1.getUltimaNotificacao());
        assertNull(dispositivo2.getUltimaNotificacao());
    }
}
