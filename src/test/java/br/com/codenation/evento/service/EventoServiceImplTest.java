package br.com.codenation.evento.service;


import br.com.codenation.evento.model.Evento;
import br.com.codenation.evento.repository.EventoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventoServiceImplTest {


    @Mock
    private EventoRepository eventoRepository;

    @InjectMocks
    private EventoServiceImpl livroServiceImpl;

    @Test
    public void testFindMaiorMediaAvaliacao() {
        mockFindLivrosComAvaliacao();
        assertEquals(new Integer(4), livroServiceImpl.findByMaiorMediaAvaliacao().getMediaAvaliacoes());
    }





    private void mockFindLivrosComAvaliacao() {
        Evento evento = mock(Evento.class);
        when(evento.getMediaAvaliacoes()).thenReturn(4);
        when(this.eventoRepository.findComAvaliacao()).thenReturn(Arrays.asList(evento));
    }


}
