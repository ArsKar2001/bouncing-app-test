package karmanchuk.bouncing.ui.controller;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import karmanchik.clientservice.entity.Agent;
import karmanchik.clientservice.jpa.AgentPagingRepository;
import karmanchuk.bouncing.ui.models.SortType;
import karmanchuk.bouncing.ui.view.AgentView;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
@RequiredArgsConstructor
public class MainUIController extends AbstractUIController {
    private static final Integer PAGE_SIZE = 10;

    private final AgentPagingRepository agentPagingRepository;

    private static Integer TOTAL_PAGE_SIZE = 0;
    private static Integer PAGE_NUMBER = 0;
    private static Sort sort = Sort.unsorted();

    public TextField tfSearch;
    public ComboBox<SortType> cbSort;
    public ComboBox<String> cbFilter;
    public Button btnBackPage;
    public Label lbPages;
    public Button btnUpPage;
    public VBox vbAgents;

    @Override
    protected void postShow() {
        updatePages(agentPagingRepository.findAll(PageRequest.of(PAGE_NUMBER, PAGE_SIZE, sort)));
    }

    private void loadAgents(List<Agent> content) {
        vbAgents.getChildren().clear();
        content.stream()
                .map(agent -> {
                    try {
                        return new AgentView(agent).build();
                    } catch (FileNotFoundException e) {
                        new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).showAndWait();
                        throw new RuntimeException(e);
                    }
                })
                .forEach(av -> vbAgents.getChildren().add(av));
        int number = PAGE_NUMBER + 1;
        lbPages.setText(number + " / " + TOTAL_PAGE_SIZE);
    }

    @Override
    protected void preShow() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnUpPage.setOnAction(e -> {
            if (PAGE_NUMBER < TOTAL_PAGE_SIZE - 1) {
                PAGE_NUMBER++;
                updatePages(agentPagingRepository.findAll(PageRequest.of(PAGE_NUMBER, PAGE_SIZE, sort)));
            }
        });
        btnBackPage.setOnAction(e -> {
            if (PAGE_NUMBER > 0) {
                PAGE_NUMBER--;
                updatePages(agentPagingRepository.findAll(PageRequest.of(PAGE_NUMBER, PAGE_SIZE, sort)));
            }
        });

        cbSort.getItems().addAll(SortType.values());

        cbSort.setOnAction(e -> {
            switch (cbSort.getValue()) {
                case NONE:
                    sort = Sort.unsorted();
                    break;
                case ASK:
                    sort = Sort.by("title", "priority").ascending();
                    break;
                case DESK:
                    sort = Sort.by("title", "priority").descending();
                    break;
            }
            PAGE_NUMBER = 0;
            updatePages(agentPagingRepository.findAll(PageRequest.of(PAGE_NUMBER, PAGE_SIZE, sort)));
        });
    }

    private void updatePages(Page<Agent> page) {
        TOTAL_PAGE_SIZE = page.getTotalPages();
        loadAgents(page.getContent());
    }
}
