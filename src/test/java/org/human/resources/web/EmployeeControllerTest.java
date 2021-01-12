package org.human.resources.web;

import org.human.resources.dto.EmployeeDto;
import org.human.resources.mapper.EmployeeMapper;
import org.human.resources.service.EmployeeService;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.hasSize;
import static org.human.resources.web.EmployeeControllerTest.RestEndpoints.GET_ENDPOINT;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith({MockitoExtension.class, SpringExtension.class})
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    enum RestEndpoints {
        BASE_URL("/employee"),
        GET_ENDPOINT(BASE_URL.url + "/get");


        private final String url;

        RestEndpoints(String url) {
            this.url = url;
        }


    }

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    private final EmployeeMapper mapper = EmployeeMapper.INSTANCE;

    EasyRandom generator = new EasyRandom();


    @Test
    void shouldGetAllEmployee() throws Exception {

        var dtos = generator.objects(EmployeeDto.class, 2).collect(toList());
        var employees = dtos.stream().map(mapper::fromDto).collect(toList());

        Mockito.when(service.findAll()).thenReturn(employees);

        mockMvc.perform(get(GET_ENDPOINT.url))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$", hasSize(dtos.size())))
            .andExpect(jsonPath("[0].id").value(dtos.get(0).getId()))
            .andExpect(jsonPath("[1].hireDate").value(dtos.get(1).getHireDate().toString()));

        verify(service, times(1)).findAll();
        verifyNoMoreInteractions(service);
    }

}