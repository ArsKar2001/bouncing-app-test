package karmanchuk.bouncing.ui.controller;

import javafx.scene.Node;
import javafx.scene.control.*;
import karmanchik.clientservice.entity.Agent;
import karmanchik.clientservice.entity.AgentType;
import karmanchik.clientservice.jpa.AgentPagingRepository;
import karmanchik.clientservice.jpa.AgentTypeRepository;
import karmanchuk.bouncing.ui.models.SortType;
import karmanchuk.bouncing.ui.view.AgentView;
import karmanchuk.bouncing.ui.view.PageAgentsView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class MainUIController extends AbstractUIController {
    private static final Integer PAGE_SIZE = 10;

    private final ListView<AgentView> agentViews = new ListView<>();

    private final AgentPagingRepository agentRepository;
    private final AgentTypeRepository agentTypeRepository;

    public Pagination pgContainer;
    public ComboBox<AgentType> cbFilter;
    public ComboBox<String> cbSort;
    public TextField tfSearch;

    @Override
    protected void postShow() {
        cbFilter.getItems().addAll(agentTypeRepository.findAll());
        loadAgents(agentRepository.findAll());
    }

    @Override
    protected void preShow() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbFilter.setOnAction(e -> searchAgent(tfSearch.getText(), cbFilter.getValue()));
        tfSearch.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.isEmpty()) {
                searchAgent(t1, cbFilter.getValue());
            } else {
                postShow();
            }
        });
    }

    private void loadAgents(List<Agent> agents) {
        agentViews.getItems().clear();
        int pageSize = agents.size() < PAGE_SIZE ? agents.size() : PAGE_SIZE;
        pgContainer.setPageCount(agents.size() / pageSize);
        pgContainer.setPageFactory(pageIndex -> {
            try {
                ListView<AgentView> view = new PageAgentsView(agents, pageIndex, pageSize).build();
                agentViews.getItems()
                        .addAll(view.getItems());
                return view;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void searchAgent(String text, AgentType type) {
        String s = text.toLowerCase();
        if (!agentViews.getItems().isEmpty()) {
            List<Agent> agents = agentViews.getItems().stream()
                    .map(AgentView::getAgent)
                    .filter(agent -> {
                        if (type == null) {
                            return true;
                        }
                        return agent.getType() == type;
                    })
                    .sorted(Comparator.comparing(Agent::getTitle))
                    .collect(Collectors.toList());
            loadAgents(agents);
        }
    }
}
