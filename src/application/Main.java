package application;

import java.awt.Point;
import java.io.IOException;
import engine.Game;
import engine.Player;
import engine.PriorityQueue;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;
import model.world.Hero;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main extends Application implements EventHandler<ActionEvent> {
	Game game;
	String s;

	Stage stage1;
	Scene HomePage;
	Scene choosingChampions;
	Scene choosingLeader;
	Scene choosingLeader2;
	Scene playing;
    Scene End;
    Scene Input;
    Scene direction;
	Button start;
	Button CaptainAmerica;
	Button Hulk;
	Button Thor;
	Button IceMan;
	Button DrStrange;
	Button Ironman;
	Button SpiderMan;
	Button Electro;
	Button Loki;
	Button QuickSilver;
	Button YellowJacket;
	Button Deadpool;
	Button Hela;
	Button Venom;
	Button GhostRider;
	Button l1;
	Button l2;
	Button l3;
	Button l11;
	Button l22;
	Button l33;

	Button zero0;
	Button zero1;
	Button zero2;
	Button zero3;
	Button zero4;
	Button one0;
	Button one1;
	Button one2;
	Button one3;
	Button one4;
	Button two0;
	Button two1;
	Button two2;
	Button two3;
	Button two4;
	Button three0;
	Button three1;
	Button three2;
	Button three3;
	Button three4;
	Button four0;
	Button four1;
	Button four2;
	Button four3;
	Button four4;
	Button attackUp;
	Button attackDown;
	Button attackLeft;
	Button attackRight;
	Button EndTurn;
	Button UP;
	Button Down;
	Button Right;
	Button Left;
	Button LeaderAbility1;
	Button LeaderAbility2;
	Button Ability1;
	Button Ability2;
	Button Ability3;
	Button singleTarget;
	Button DUP;
	Button DDown;
	Button DRight;
	Button DLeft;

	TextField player1name;
	TextField player2name;
	TextField xcoor;
	TextField ycoor;
	
	int Ab=0;
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		// Layout
		stage1 = stage;
		StackPane layouthome = new StackPane();
		HomePage = new Scene(layouthome);

		// Home page
		start = new Button();
		start.setText("Start");
		start.setOnAction(this);
		start.setMinHeight(40);
		start.setMinWidth(200);
		StackPane.setAlignment(start, Pos.BOTTOM_CENTER);

		Label player1 = new Label("Player 1 username:");
		player1.setFont(new Font("Arial", 24));
		player1name = new TextField();
		player1name.setPrefWidth(300);
		Label player2 = new Label("Player 2 username:");
		player2name = new TextField();
		player2.setFont(new Font("Arial", 24));
		player2name.setPrefWidth(300);
		HBox x1 = new HBox(player1, player1name);
		HBox x2 = new HBox(player2, player2name);
		VBox y = new VBox(x1, x2);
		y.setPadding(new Insets(30, 30, 30, 30));
		y.setSpacing(10);
		StackPane.setAlignment(y, Pos.CENTER_RIGHT);

		Image image = new Image("final back.jpg");
		ImageView mg = new ImageView(image);
		layouthome.getChildren().addAll(mg, y, start);
		Image icon = new Image("marvel logo.jpg");
		stage1.getIcons().add(icon);
		stage1.setTitle("fight Club");
		stage1.setScene(HomePage);
		stage1.show();
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == start) {
			if (player1name.getText().equals("") || player2name.getText().equals("")) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Input not valid");
				errorAlert.setContentText("PLEASE ENTER BOTH NAMES");
				errorAlert.showAndWait();
			} else {
				String name1 = player1name.getText();
				String name2 = player2name.getText();
				game = creatingGame(name1, name2);
				try {
					Game.loadAbilities("Abilities.csv");
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					Game.loadChampions("Champions.csv");
				} catch (IOException e) {
					e.printStackTrace();
				}
				ChoosingChampionSceneMethod();
			}
		}

		if (event.getSource() == CaptainAmerica) {
			s = "Captain America";
			Champion e = playerTeam(s, game);
			if (game.getFirstPlayer().getTeam().contains(e) || game.getSecondPlayer().getTeam().contains(e)) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Unavailable");
				errorAlert.setContentText("Please Choose from the unchosen champions");
				errorAlert.showAndWait();
			} else if (game.getFirstPlayer().getTeam().size() < 3)
				game.getFirstPlayer().getTeam().add(e);
			else
				game.getSecondPlayer().getTeam().add(e);
			if (game.getFirstPlayer().getTeam().size() == 3 && game.getSecondPlayer().getTeam().size() == 3) {
				ChoosingLeaderSceneMethod();
			}
		}
		if (event.getSource() == Hulk) {
			s = "Hulk";
			Champion e = playerTeam(s, game);
			if (game.getFirstPlayer().getTeam().contains(e) || game.getSecondPlayer().getTeam().contains(e)) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Unavailable");
				errorAlert.setContentText("Please Choose from the unchosen champions");
				errorAlert.showAndWait();
			} else if (game.getFirstPlayer().getTeam().size() < 3)
				game.getFirstPlayer().getTeam().add(e);
			else
				game.getSecondPlayer().getTeam().add(e);
			if (game.getFirstPlayer().getTeam().size() == 3 && game.getSecondPlayer().getTeam().size() == 3) {
				ChoosingLeaderSceneMethod();
			}
		}
		if (event.getSource() == Ironman) {
			s = "Ironman";
			Champion e = playerTeam(s, game);
			if (game.getFirstPlayer().getTeam().contains(e) || game.getSecondPlayer().getTeam().contains(e)) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Unavailable");
				errorAlert.setContentText("Please Choose from the unchosen champions");
				errorAlert.showAndWait();
			} else if (game.getFirstPlayer().getTeam().size() < 3)
				game.getFirstPlayer().getTeam().add(e);
			else
				game.getSecondPlayer().getTeam().add(e);
			if (game.getFirstPlayer().getTeam().size() == 3 && game.getSecondPlayer().getTeam().size() == 3) {
				ChoosingLeaderSceneMethod();
			}
		}
		if (event.getSource() == SpiderMan) {
			s = "Spiderman";
			Champion e = playerTeam(s, game);
			if (game.getFirstPlayer().getTeam().contains(e) || game.getSecondPlayer().getTeam().contains(e)) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Unavailable");
				errorAlert.setContentText("Please Choose from the unchosen champions");
				errorAlert.showAndWait();
			} else if (game.getFirstPlayer().getTeam().size() < 3)
				game.getFirstPlayer().getTeam().add(e);
			else
				game.getSecondPlayer().getTeam().add(e);
			if (game.getFirstPlayer().getTeam().size() == 3 && game.getSecondPlayer().getTeam().size() == 3) {
				ChoosingLeaderSceneMethod();
			}
		}
		if (event.getSource() == Electro) {
			s = "Electro";
			Champion e = playerTeam(s, game);
			if (game.getFirstPlayer().getTeam().contains(e) || game.getSecondPlayer().getTeam().contains(e)) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Unavailable");
				errorAlert.setContentText("Please Choose from the unchosen champions");
				errorAlert.showAndWait();
			} else if (game.getFirstPlayer().getTeam().size() < 3)
				game.getFirstPlayer().getTeam().add(e);
			else
				game.getSecondPlayer().getTeam().add(e);
			if (game.getFirstPlayer().getTeam().size() == 3 && game.getSecondPlayer().getTeam().size() == 3) {
				ChoosingLeaderSceneMethod();
			}
		}
		if (event.getSource() == Loki) {
			s = "Loki";
			Champion e = playerTeam(s, game);
			if (game.getFirstPlayer().getTeam().contains(e) || game.getSecondPlayer().getTeam().contains(e)) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Unavailable");
				errorAlert.setContentText("Please Choose from the unchosen champions");
				errorAlert.showAndWait();
			} else if (game.getFirstPlayer().getTeam().size() < 3)
				game.getFirstPlayer().getTeam().add(e);
			else
				game.getSecondPlayer().getTeam().add(e);
			if (game.getFirstPlayer().getTeam().size() == 3 && game.getSecondPlayer().getTeam().size() == 3) {
				ChoosingLeaderSceneMethod();
			}
		}
		if (event.getSource() == QuickSilver) {
			s = "Quicksilver";
			Champion e = playerTeam(s, game);
			if (game.getFirstPlayer().getTeam().contains(e) || game.getSecondPlayer().getTeam().contains(e)) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Unavailable");
				errorAlert.setContentText("Please Choose from the unchosen champions");
				errorAlert.showAndWait();
			} else if (game.getFirstPlayer().getTeam().size() < 3)
				game.getFirstPlayer().getTeam().add(e);
			else
				game.getSecondPlayer().getTeam().add(e);
			if (game.getFirstPlayer().getTeam().size() == 3 && game.getSecondPlayer().getTeam().size() == 3) {
				ChoosingLeaderSceneMethod();
			}
		}
		if (event.getSource() == YellowJacket) {
			s = "Yellow Jacket";
			Champion e = playerTeam(s, game);
			if (game.getFirstPlayer().getTeam().contains(e) || game.getSecondPlayer().getTeam().contains(e)) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Unavailable");
				errorAlert.setContentText("Please Choose from the unchosen champions");
				errorAlert.showAndWait();
			} else if (game.getFirstPlayer().getTeam().size() < 3)
				game.getFirstPlayer().getTeam().add(e);
			else
				game.getSecondPlayer().getTeam().add(e);
			if (game.getFirstPlayer().getTeam().size() == 3 && game.getSecondPlayer().getTeam().size() == 3) {
				ChoosingLeaderSceneMethod();
			}
		}
		if (event.getSource() == Deadpool) {
			s = "Deadpool";
			Champion e = playerTeam(s, game);
			if (game.getFirstPlayer().getTeam().contains(e) || game.getSecondPlayer().getTeam().contains(e)) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Unavailable");
				errorAlert.setContentText("Please Choose from the unchosen champions");
				errorAlert.showAndWait();
			} else if (game.getFirstPlayer().getTeam().size() < 3)
				game.getFirstPlayer().getTeam().add(e);
			else
				game.getSecondPlayer().getTeam().add(e);
			if (game.getFirstPlayer().getTeam().size() == 3 && game.getSecondPlayer().getTeam().size() == 3) {
				ChoosingLeaderSceneMethod();
			}
		}
		if (event.getSource() == Hela) {
			s = "Hela";
			Champion e = playerTeam(s, game);
			if (game.getFirstPlayer().getTeam().contains(e) || game.getSecondPlayer().getTeam().contains(e)) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Unavailable");
				errorAlert.setContentText("Please Choose from the unchosen champions");
				errorAlert.showAndWait();
			} else if (game.getFirstPlayer().getTeam().size() < 3)
				game.getFirstPlayer().getTeam().add(e);
			else
				game.getSecondPlayer().getTeam().add(e);
			if (game.getFirstPlayer().getTeam().size() == 3 && game.getSecondPlayer().getTeam().size() == 3) {
				ChoosingLeaderSceneMethod();
			}
		}
		if (event.getSource() == Venom) {
			s = "Venom";
			Champion e = playerTeam(s, game);
			if (game.getFirstPlayer().getTeam().contains(e) || game.getSecondPlayer().getTeam().contains(e)) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Unavailable");
				errorAlert.setContentText("Please Choose from the unchosen champions");
				errorAlert.showAndWait();
			} else if (game.getFirstPlayer().getTeam().size() < 3)
				game.getFirstPlayer().getTeam().add(e);
			else
				game.getSecondPlayer().getTeam().add(e);
			if (game.getFirstPlayer().getTeam().size() == 3 && game.getSecondPlayer().getTeam().size() == 3) {
				ChoosingLeaderSceneMethod();
			}
		}
		if (event.getSource() == GhostRider) {
			s = "Ghost Rider";
			Champion e = playerTeam(s, game);
			if (game.getFirstPlayer().getTeam().contains(e) || game.getSecondPlayer().getTeam().contains(e)) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Unavailable");
				errorAlert.setContentText("Please Choose from the unchosen champions");
				errorAlert.showAndWait();
			} else if (game.getFirstPlayer().getTeam().size() < 3)
				game.getFirstPlayer().getTeam().add(e);
			else
				game.getSecondPlayer().getTeam().add(e);
			if (game.getFirstPlayer().getTeam().size() == 3 && game.getSecondPlayer().getTeam().size() == 3) {
				ChoosingLeaderSceneMethod();
			}
		}
		if (event.getSource() == DrStrange) {
			s = "Dr Strange";
			Champion e = playerTeam(s, game);
			if (game.getFirstPlayer().getTeam().contains(e) || game.getSecondPlayer().getTeam().contains(e)) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Unavailable");
				errorAlert.setContentText("Please Choose from the unchosen champions");
				errorAlert.showAndWait();
			} else if (game.getFirstPlayer().getTeam().size() < 3)
				game.getFirstPlayer().getTeam().add(e);
			else
				game.getSecondPlayer().getTeam().add(e);
			if (game.getFirstPlayer().getTeam().size() == 3 && game.getSecondPlayer().getTeam().size() == 3) {
				ChoosingLeaderSceneMethod();
			}
		}
		if (event.getSource() == IceMan) {
			s = "Iceman";
			Champion e = playerTeam(s, game);
			if (game.getFirstPlayer().getTeam().contains(e) || game.getSecondPlayer().getTeam().contains(e)) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Unavailable");
				errorAlert.setContentText("Please Choose from the unchosen champions");
				errorAlert.showAndWait();
			} else if (game.getFirstPlayer().getTeam().size() < 3)
				game.getFirstPlayer().getTeam().add(e);
			else
				game.getSecondPlayer().getTeam().add(e);
			if (game.getFirstPlayer().getTeam().size() == 3 && game.getSecondPlayer().getTeam().size() == 3) {
				ChoosingLeaderSceneMethod();
			}
		}
		if (event.getSource() == Thor) {
			s = "Thor";
			Champion e = playerTeam(s, game);
			if (game.getFirstPlayer().getTeam().contains(e) || game.getSecondPlayer().getTeam().contains(e)) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Unavailable");
				errorAlert.setContentText("Please Choose from the unchosen champions");
				errorAlert.showAndWait();
			} else if (game.getFirstPlayer().getTeam().size() < 3)
				game.getFirstPlayer().getTeam().add(e);
			else
				game.getSecondPlayer().getTeam().add(e);
			if (game.getFirstPlayer().getTeam().size() == 3 && game.getSecondPlayer().getTeam().size() == 3) {
				ChoosingLeaderSceneMethod();
			}
		}

		if (event.getSource() == l1) {
			game.getFirstPlayer().setLeader(game.getFirstPlayer().getTeam().get(0));
			ChoosingLeaderScene2Method();
		}

		if (event.getSource() == l2) {
			game.getFirstPlayer().setLeader(game.getFirstPlayer().getTeam().get(1));
			ChoosingLeaderScene2Method();
		}

		if (event.getSource() == l3) {
			game.getFirstPlayer().setLeader(game.getFirstPlayer().getTeam().get(2));
			ChoosingLeaderScene2Method();
		}

		if (event.getSource() == l11) {
			game.getSecondPlayer().setLeader(game.getSecondPlayer().getTeam().get(0));
			Player p1 = game.getFirstPlayer();
			Player p2 = game.getSecondPlayer();
			game = new Game(p1, p2);
			try {
				Game.loadAbilities("Abilities.csv");
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Game.loadChampions("Champions.csv");
			} catch (IOException e) {
				e.printStackTrace();
			}
			playSceneMethod();
		}

		if (event.getSource() == l22) {
			game.getSecondPlayer().setLeader(game.getSecondPlayer().getTeam().get(1));
			Player p1 = game.getFirstPlayer();
			Player p2 = game.getSecondPlayer();
			game = new Game(p1, p2);
			try {
				Game.loadAbilities("Abilities.csv");
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Game.loadChampions("Champions.csv");
			} catch (IOException e) {
				e.printStackTrace();
			}
			playSceneMethod();
		}

		if (event.getSource() == l33) {
			game.getSecondPlayer().setLeader(game.getSecondPlayer().getTeam().get(2));
			Player p1 = game.getFirstPlayer();
			Player p2 = game.getSecondPlayer();
			game = new Game(p1, p2);
			try {
				Game.loadAbilities("Abilities.csv");
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Game.loadChampions("Champions.csv");
			} catch (IOException e) {
				e.printStackTrace();
			}
			playSceneMethod();
		}

		if (event.getSource() == UP) {
			try {
				game.move(Direction.UP);
				playSceneMethod();
			} catch (NotEnoughResourcesException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Can't move");
				errorAlert.setContentText("Not Enough Resources ");
				errorAlert.showAndWait();

			} catch (UnallowedMovementException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Can't move");
				errorAlert.setContentText("Unallowed Movement Exception ");
				errorAlert.showAndWait();
			}
		}

		if (event.getSource() == Down) {
			try {
				game.move(Direction.DOWN);
				playSceneMethod();
			} catch (NotEnoughResourcesException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Can't move");
				errorAlert.setContentText("Not Enough Resources ");
				errorAlert.showAndWait();
			} catch (UnallowedMovementException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Can't move");
				errorAlert.setContentText("Unallowed Movement Exception ");
				errorAlert.showAndWait();
			}
		}

		if (event.getSource() == Right && !game.getTurnOrder().isEmpty()) {
			try {
				game.move(Direction.RIGHT);
				playSceneMethod();
			} catch (NotEnoughResourcesException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Can't move");
				errorAlert.setContentText("Not Enough Resources ");
				errorAlert.showAndWait();

			} catch (UnallowedMovementException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Can't move");
				errorAlert.setContentText("Unallowed Movement Exception ");
				errorAlert.showAndWait();
			}
		}

		if (event.getSource() == Left && !game.getTurnOrder().isEmpty()) {
			try {
				game.move(Direction.LEFT);
				playSceneMethod();
			} catch (NotEnoughResourcesException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Can't move");
				errorAlert.setContentText("Not Enough Resources ");
				errorAlert.showAndWait();

			} catch (UnallowedMovementException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Can't move");
				errorAlert.setContentText("Unallowed Movement Exception ");
				errorAlert.showAndWait();
			}
		}

		if (event.getSource() == attackUp) {
			try {
				game.attack(Direction.UP);
				playSceneMethod();
			} catch (NotEnoughResourcesException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Can't Attack");
				errorAlert.setContentText("Not Enough Resources Exception ");
				errorAlert.showAndWait();
			} catch (ChampionDisarmedException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Can't Attack");
				errorAlert.setContentText("Champion Disarmed Exception ");
				errorAlert.showAndWait();
			} catch (InvalidTargetException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Can't Attack");
				errorAlert.setContentText("Invalid Target Exception ");
				errorAlert.showAndWait();
			}
		}

		if (event.getSource() == attackDown) {
			try {
				game.attack(Direction.DOWN);
				playSceneMethod();
			} catch (NotEnoughResourcesException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Cann't Attack");
				errorAlert.setContentText("Not Enough Resources Exception ");
				errorAlert.showAndWait();
			} catch (ChampionDisarmedException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Cann't Attack");
				errorAlert.setContentText("Champion Disarmed Exception ");
				errorAlert.showAndWait();
			} catch (InvalidTargetException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Cann't Attack");
				errorAlert.setContentText("Invalid Target Exception ");
				errorAlert.showAndWait();
			}
		}

		if (event.getSource() == attackRight) {
			try {
				game.attack(Direction.RIGHT);
				playSceneMethod();
			} catch (NotEnoughResourcesException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Can't Attack");
				errorAlert.setContentText("Not Enough Resources Exception ");
				errorAlert.showAndWait();
			} catch (ChampionDisarmedException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Can't Attack");
				errorAlert.setContentText("Champion Disarmed Exception ");
				errorAlert.showAndWait();
			} catch (InvalidTargetException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Can't Attack");
				errorAlert.setContentText("Invalid Target Exception ");
				errorAlert.showAndWait();
			}
		}

		if (event.getSource() == attackLeft) {
			try {
				game.attack(Direction.LEFT);
				playSceneMethod();
			} catch (NotEnoughResourcesException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Cann't Attack");
				errorAlert.setContentText("Not Enough Resources Exception ");
				errorAlert.showAndWait();
			} catch (ChampionDisarmedException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Cann't Attack");
				errorAlert.setContentText("Champion Disarmed Exception ");
				errorAlert.showAndWait();
			} catch (InvalidTargetException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion Cann't Attack");
				errorAlert.setContentText("Invalid Target Exception ");
				errorAlert.showAndWait();
			}
		}

		if (event.getSource() == EndTurn) {
			game.endTurn();
			playSceneMethod();
		}

		if (event.getSource() == LeaderAbility1) {
			try {
				game.useLeaderAbility();
				playSceneMethod();
			} catch (LeaderNotCurrentException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion isn't the Leader");
				errorAlert.setContentText("Leader Not Current Exception ");
				errorAlert.showAndWait();
			} catch (LeaderAbilityAlreadyUsedException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Already Used");
				errorAlert.setContentText("Leader Ability Already Used Exception ");
				errorAlert.showAndWait();
			}
		}

		if (event.getSource() == LeaderAbility2) {
			try {
				game.useLeaderAbility();
				playSceneMethod();
			} catch (LeaderNotCurrentException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Champion isn't the Leader");
				errorAlert.setContentText("Leader Not Current Exception ");
				errorAlert.showAndWait();
			} catch (LeaderAbilityAlreadyUsedException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Already Used");
				errorAlert.setContentText("Leader Ability Already Used Exception ");
				errorAlert.showAndWait();
			}
		}

		if (event.getSource() == Ability1) {
			Ability temp = game.getCurrentChampion().getAbilities().get(0);
			if (temp.getCastArea() == AreaOfEffect.SURROUND || temp.getCastArea() == AreaOfEffect.TEAMTARGET
					|| temp.getCastArea() == AreaOfEffect.SELFTARGET) {
				try {
					game.castAbility(temp);
					playSceneMethod();
				} catch (NotEnoughResourcesException e) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("cann't cast the ability");
					errorAlert.setContentText(" Not Enough Resources Exception");
					errorAlert.showAndWait();
				} catch (AbilityUseException e) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("cann't cast the ability");
					errorAlert.setContentText(" Ability Exception");
					errorAlert.showAndWait();
				} catch (CloneNotSupportedException e) {
					
					e.printStackTrace();
				}

			} else if (temp.getCastArea() == AreaOfEffect.DIRECTIONAL) {
				directional();
				Ab=0;
			
			} else if (temp.getCastArea() == AreaOfEffect.SINGLETARGET) {
			    Ab=0;
				inputScene();
                
			}
			
		}

		if (event.getSource() == Ability2) {
			Ability temp = game.getCurrentChampion().getAbilities().get(1);
			if (temp.getCastArea() == AreaOfEffect.SURROUND || temp.getCastArea() == AreaOfEffect.TEAMTARGET
					|| temp.getCastArea() == AreaOfEffect.SELFTARGET) {
				try {
					game.castAbility(temp);
					playSceneMethod();
				} catch (NotEnoughResourcesException e) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("cann't cast the ability");
					errorAlert.setContentText(" Not Enough Resources Exception");
					errorAlert.showAndWait();
				} catch (AbilityUseException e) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("cann't cast the ability");
					errorAlert.setContentText(" Ability Exception");
					errorAlert.showAndWait();
				} catch (CloneNotSupportedException e) {
					
					e.printStackTrace();
				}

			} else if (temp.getCastArea() == AreaOfEffect.DIRECTIONAL) {
			directional();
			Ab=1;
		
			} else if (temp.getCastArea() == AreaOfEffect.SINGLETARGET) {
			
				inputScene();
				Ab=1;
                
			}
		
		}

		if (event.getSource() == Ability3) {
			Ability temp = game.getCurrentChampion().getAbilities().get(2);
			if (temp.getCastArea() == AreaOfEffect.SURROUND || temp.getCastArea() == AreaOfEffect.TEAMTARGET
					|| temp.getCastArea() == AreaOfEffect.SELFTARGET) {
				try {
					game.castAbility(temp);
					playSceneMethod();
				} catch (NotEnoughResourcesException e) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("cann't cast the ability");
					errorAlert.setContentText(" Not Enough Resources Exception");
					errorAlert.showAndWait();
				} catch (AbilityUseException e) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("cann't cast the ability");
					errorAlert.setContentText(" Ability Exception");
					errorAlert.showAndWait();
				} catch (CloneNotSupportedException e) {
					
					e.printStackTrace();
				}

			} else if (temp.getCastArea() == AreaOfEffect.DIRECTIONAL) {
				directional();
				Ab=2;
			} else if (temp.getCastArea() == AreaOfEffect.SINGLETARGET) {
			
				inputScene();
				Ab=2;                
			}
			
		}

		if (stage1.getScene() == playing && game.checkGameOver() != null)
			EndSceneMethod();
		if (event.getSource()== singleTarget)
		{   
			Ability temp = game.getCurrentChampion().getAbilities().get(Ab);
			int x = Integer.parseInt(xcoor.getText());
			int y = Integer.parseInt(ycoor.getText());
			playSceneMethod();
			try {
				game.castAbility(temp, x, y);
			} catch (NotEnoughResourcesException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("cann't cast the ability");
				errorAlert.setContentText(" Not enough resources Exception");
				errorAlert.showAndWait();
			} catch (AbilityUseException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("cann't cast the ability");
				errorAlert.setContentText(" Ability use Exception");
				errorAlert.showAndWait();
			} catch (InvalidTargetException e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("cann't cast the ability");
				errorAlert.setContentText(" Invalid target Exception");
				errorAlert.showAndWait();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(event.getSource()== DUP)
		{  
			Ability temp =  game.getCurrentChampion().getAbilities().get(Ab);
			playSceneMethod();
				try {
					game.castAbility(temp, Direction.UP);
				
				} catch (NotEnoughResourcesException e3) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("cann't cast the ability");
					errorAlert.setContentText(" Not Enough Resources Exception");
					errorAlert.showAndWait();
				} catch (AbilityUseException e3) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("cann't cast the ability");
					errorAlert.setContentText(" Ability use Exception");
					errorAlert.showAndWait();
				
				} catch (CloneNotSupportedException e3) {
					
					e3.printStackTrace();
				}
		}	
		if(event.getSource()== DDown)
		{  
			Ability temp =  game.getCurrentChampion().getAbilities().get(Ab);
			playSceneMethod();
				try {
					game.castAbility(temp, Direction.DOWN);
					
				} catch (NotEnoughResourcesException e3) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("cann't cast the ability");
					errorAlert.setContentText(" Not Enough Resources Exception");
					errorAlert.showAndWait();
				} catch (AbilityUseException e3) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("cann't cast the ability");
					errorAlert.setContentText(" Ability use Exception");
					errorAlert.showAndWait();
				
				} catch (CloneNotSupportedException e3) {
					
					e3.printStackTrace();
				}
		}	
		if(event.getSource()== DLeft)
		{  
			Ability temp =  game.getCurrentChampion().getAbilities().get(Ab);
			playSceneMethod();
				try {
					game.castAbility(temp, Direction.LEFT);
					
				} catch (NotEnoughResourcesException e3) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("cann't cast the ability");
					errorAlert.setContentText(" Not Enough Resources Exception");
					errorAlert.showAndWait();
				} catch (AbilityUseException e3) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("cann't cast the ability");
					errorAlert.setContentText(" Ability use Exception");
					errorAlert.showAndWait();
				
				} catch (CloneNotSupportedException e3) {
					
					e3.printStackTrace();
				}
		}
		if(event.getSource()== DRight)
		{  
			Ability temp =  game.getCurrentChampion().getAbilities().get(Ab);
			playSceneMethod();
				try {
					game.castAbility(temp, Direction.RIGHT);
					
				} catch (NotEnoughResourcesException e3) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("cann't cast the ability");
					errorAlert.setContentText(" Not Enough Resources Exception");
					errorAlert.showAndWait();
				} catch (AbilityUseException e3) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("cann't cast the ability");
					errorAlert.setContentText(" Ability use Exception");
					errorAlert.showAndWait();
				
				} catch (CloneNotSupportedException e3) {
					
					e3.printStackTrace();
				}
		}	
	}

	public void EndSceneMethod() {
		StackPane finalGame = new StackPane();
		End = new Scene(finalGame);
		Label l = new Label("The Winner is" + game.checkGameOver().getName());
		l.setFont(new Font("Arial", 48));
		ImageView image = new ImageView("ENDSCENE.jpg");
		finalGame.getChildren().addAll(image,l);
		stage1.setScene(End);
	}
	public void directional() {
		StackPane dd= new StackPane();
		direction= new Scene(dd);
		DUP= new Button();
		DUP.setOnAction(this);
		DUP.setText("UP");
		DUP.setMinHeight(25);
		DUP.setMinWidth(120);
		DDown= new Button();
		DDown.setOnAction(this);
		DDown.setText("Down");
		DDown.setMinHeight(25);
		DDown.setMinWidth(120);
		DRight= new Button();
		DRight.setOnAction(this);
		DRight.setText("Right");
		DRight.setMinHeight(25);
		DRight.setMinWidth(120);
		DLeft= new Button();
		DLeft.setOnAction(this);
		DLeft.setText("Left");
		DLeft.setMinHeight(25);
		DLeft.setMinWidth(120);
		VBox d= new VBox();
		d.getChildren().addAll(DUP,DDown,DRight,DLeft);
		dd.getChildren().add(d);
		stage1.setScene(direction);
	}
	
	public void inputScene() {
		StackPane single= new StackPane();
		Input = new Scene(single);
		xcoor= new TextField();
		ycoor= new TextField();
		Label x = new Label("Please enter x coordinate");
		Label y = new Label("Please enter Y coordinate");
		HBox xc= new HBox();
		xc.getChildren().addAll(x,xcoor);
		HBox yc= new HBox();
		yc.getChildren().addAll(y,ycoor);
		VBox input = new VBox();
		singleTarget= new Button();
		singleTarget.setOnAction(this);
		singleTarget.setText("Next");
		singleTarget.setAlignment(Pos.CENTER);
		singleTarget.setMinHeight(30);
		singleTarget.setMinWidth(160);
		input.getChildren().addAll(xc,yc,singleTarget);
		single.getChildren().add(input);
		stage1.setScene(Input);
	}
	public void ChoosingChampionSceneMethod() {
		StackPane Choosing = new StackPane();
		choosingChampions = new Scene(Choosing);

		CaptainAmerica = new Button();
		CaptainAmerica.setOnAction(this);
		Hulk = new Button();
		Hulk.setOnAction(this);
		Thor = new Button();
		Thor.setOnAction(this);
		IceMan = new Button();
		IceMan.setOnAction(this);
		DrStrange = new Button();
		DrStrange.setOnAction(this);
		Ironman = new Button();
		Ironman.setOnAction(this);
		SpiderMan = new Button();
		SpiderMan.setOnAction(this);
		CaptainAmerica.setMaxSize(16, 16);
		Hulk.setMaxSize(16, 16);
		Thor.setMaxSize(16, 16);
		IceMan.setMaxSize(16, 16);
		DrStrange.setMaxSize(16, 16);
		Ironman.setMaxSize(16, 16);
		SpiderMan.setMaxSize(16, 16);
		CaptainAmerica.setGraphic(new ImageView("Captain America fs.jpg"));
		Hulk.setGraphic(new ImageView("Hulk.jpg"));
		Thor.setGraphic(new ImageView("THOR.jpg"));
		IceMan.setGraphic(new ImageView("Iceman.jpg"));
		DrStrange.setGraphic(new ImageView("strange.jpg"));
		Ironman.setGraphic(new ImageView("ironman.jpg"));
		SpiderMan.setGraphic(new ImageView("SpiderMna.jpg"));
		HBox b1 = new HBox(CaptainAmerica, Hulk, Thor, IceMan, DrStrange);

		Electro = new Button();
		Electro.setOnAction(this);
		Loki = new Button();
		Loki.setOnAction(this);
		QuickSilver = new Button();
		QuickSilver.setOnAction(this);
		YellowJacket = new Button();
		YellowJacket.setOnAction(this);
		Electro.setMaxSize(16, 16);
		Loki.setMaxSize(16, 16);
		QuickSilver.setMaxSize(16, 16);
		YellowJacket.setMaxSize(16, 16);
		Electro.setGraphic(new ImageView("Electro.jpg"));
		Loki.setGraphic(new ImageView("loki.jpg"));
		QuickSilver.setGraphic(new ImageView("Quick.jpg"));
		YellowJacket.setGraphic(new ImageView("yellow.jpg"));
		HBox b2 = new HBox(Ironman, SpiderMan, Electro, Loki, QuickSilver);

		Deadpool = new Button();
		Deadpool.setOnAction(this);
		Hela = new Button();
		Hela.setOnAction(this);
		Venom = new Button();
		Venom.setOnAction(this);
		GhostRider = new Button();
		GhostRider.setOnAction(this);
		Deadpool.setMaxSize(16, 16);
		Hela.setMaxSize(16, 16);
		Venom.setMaxSize(16, 16);
		GhostRider.setMaxSize(16, 16);
		Deadpool.setGraphic(new ImageView("dead.jpg"));
		Venom.setGraphic(new ImageView("venom.jpg"));
		Hela.setGraphic(new ImageView("hela.jpg"));
		GhostRider.setGraphic(new ImageView("ghost.jpg"));
		HBox b3 = new HBox(YellowJacket, Deadpool, Hela, Venom, GhostRider);

		HBox CaptainAmericaNameType = new HBox();
		Text CaptainAmericaNameTypetext = new Text("Name:Captain America, Type:Hero");
		CaptainAmericaNameType.getChildren().add(CaptainAmericaNameTypetext);
		HBox CaptainAmericaManaMaxHpActionPoints = new HBox();
		Text CaptainAmericaManaMaxHpActionPointstext = new Text("MaxHP:1500, Mana:1000, ActionPoints:6");
		CaptainAmericaManaMaxHpActionPoints.getChildren().add(CaptainAmericaManaMaxHpActionPointstext);
		HBox CaptainAmericasSpeedRangeDamage = new HBox();
		Text CaptainAmericasSpeedRangeDamagetext = new Text("speed:80, Range:1, Damage:100");
		CaptainAmericasSpeedRangeDamage.getChildren().add(CaptainAmericasSpeedRangeDamagetext);
		HBox CaptainAmericasAbilities = new HBox();
		Text CaptainAmericasAbilitiestext = new Text("Ability1:Sheild Thorw, Ability2:Sheild Up");
		CaptainAmericasAbilities.getChildren().add(CaptainAmericasAbilitiestext);
		HBox CaptainAmericasAbility = new HBox();
		Text CaptainAmericasAbilitytext = new Text("Ability3:Ican do this all day");
		CaptainAmericasAbility.getChildren().add(CaptainAmericasAbilitytext);
		VBox CaptainAmericavertical = new VBox();
		CaptainAmericavertical.getChildren().addAll(CaptainAmericaNameType, CaptainAmericaManaMaxHpActionPoints,
				CaptainAmericasSpeedRangeDamage, CaptainAmericasAbilities, CaptainAmericasAbility);

		HBox HULKNameType = new HBox();
		Text HULKNameTypetext = new Text("Name:Hulk, Type:Hero");
		HULKNameType.getChildren().add(HULKNameTypetext);
		HBox HULKManaMaxHpActionPoints = new HBox();
		Text HULKManaMaxHpActionPointstext = new Text("MaxHP:2250, Mana:550, ActionPoints:5");
		HULKManaMaxHpActionPoints.getChildren().add(HULKManaMaxHpActionPointstext);
		HBox HULKSpeedRangeDamage = new HBox();
		Text HULKSpeedRangeDamagetext = new Text("speed:55, Range:1, Damage:200");
		HULKSpeedRangeDamage.getChildren().add(HULKSpeedRangeDamagetext);
		HBox HULKAbilities = new HBox();
		Text HULKAbilitiestext = new Text("Ability1:Rage, Ability2:Hulk Smash");
		HULKAbilities.getChildren().add(HULKAbilitiestext);
		HBox HULKAbility = new HBox();
		Text HULKAbilitytext = new Text("Ability3:Sun is getting reallow ability");
		HULKAbility.getChildren().add(HULKAbilitytext);
		VBox HULKvertical = new VBox();
		HULKvertical.getChildren().addAll(HULKNameType, HULKManaMaxHpActionPoints, HULKSpeedRangeDamage, HULKAbilities,
				HULKAbility);

		HBox THORNameType = new HBox();
		Text THORNameTypetext = new Text("Name:THOR, Type:Hero");
		THORNameType.getChildren().add(THORNameTypetext);
		HBox THORManaMaxHpActionPoints = new HBox();
		Text THORManaMaxHpActionPointstext = new Text("MaxHP:1800, Mana:800, ActionPoints:7");
		THORManaMaxHpActionPoints.getChildren().add(THORManaMaxHpActionPointstext);
		HBox THORSpeedRangeDamage = new HBox();
		Text THORSpeedRangeDamagetext = new Text("speed:90, Range:1, Damage:130");
		THORSpeedRangeDamage.getChildren().add(THORSpeedRangeDamagetext);
		HBox THORAbilities = new HBox();
		Text THORAbilitiestext = new Text("Ability1:God of Thunder, Ability2:Mjollnir Throw");
		THORAbilities.getChildren().add(THORAbilitiestext);
		HBox THORAbility = new HBox();
		Text THORAbilitytext = new Text("Ability3:Bring Me Thanos ability");
		THORAbility.getChildren().add(THORAbilitytext);
		VBox THORvertical = new VBox();
		THORvertical.getChildren().addAll(THORNameType, THORManaMaxHpActionPoints, THORSpeedRangeDamage, THORAbilities,
				THORAbility);

		HBox ICENameType = new HBox();
		Text ICENameTypetext = new Text("Name:Iceman, Type:Hero");
		ICENameType.getChildren().add(ICENameTypetext);
		HBox ICEManaMaxHpActionPoints = new HBox();
		Text ICEManaMaxHpActionPointstext = new Text("MaxHP:1000, Mana:900, ActionPoints:5");
		ICEManaMaxHpActionPoints.getChildren().add(ICEManaMaxHpActionPointstext);
		HBox ICESpeedRangeDamage = new HBox();
		Text ICESpeedRangeDamagetext = new Text("speed:65, Range:2, Damage:120");
		ICESpeedRangeDamage.getChildren().add(ICESpeedRangeDamagetext);
		HBox ICEAbilities = new HBox();
		Text ICEAbilitiestext = new Text("Ability1:Frost bite, Ability2:SubZero");
		ICEAbilities.getChildren().add(ICEAbilitiestext);
		HBox ICEAbility = new HBox();
		Text ICEAbilitytext = new Text("Ability3:Hail Storm");
		ICEAbility.getChildren().add(ICEAbilitytext);
		VBox ICEvertical = new VBox();
		ICEvertical.getChildren().addAll(ICENameType, ICEManaMaxHpActionPoints, ICESpeedRangeDamage, ICEAbilities,
				ICEAbility);

		HBox DRNameType = new HBox();
		Text DRNameTypetext = new Text("Name:Dr Strange, Type:Hero");
		DRNameType.getChildren().add(DRNameTypetext);
		HBox DRManaMaxHpActionPoints = new HBox();
		Text DRManaMaxHpActionPointstext = new Text("MaxHP:1100, Mana:1500, ActionPoints:6");
		DRManaMaxHpActionPoints.getChildren().add(DRManaMaxHpActionPointstext);
		HBox DRSpeedRangeDamage = new HBox();
		Text DRSpeedRangeDamagetext = new Text("speed:60, Range:2, Damage:60");
		DRSpeedRangeDamage.getChildren().add(DRSpeedRangeDamagetext);
		HBox DRAbilities = new HBox();
		Text DRAbilitiestext = new Text("Ability1:Thousand Hand, Ability2:Mirror Dimension");
		DRAbilities.getChildren().add(DRAbilitiestext);
		HBox DRAbility = new HBox();
		Text DRAbilitytext = new Text("Ability3:The eye of agamotto");
		DRAbility.getChildren().add(DRAbilitytext);
		VBox DRvertical = new VBox();
		DRvertical.getChildren().addAll(DRNameType, DRManaMaxHpActionPoints, DRSpeedRangeDamage, DRAbilities,
				DRAbility);

		HBox IRNameType = new HBox();
		Text IRNameTypetext = new Text("Name:Iron Man, Type:Hero");
		IRNameType.getChildren().add(IRNameTypetext);
		HBox IRManaMaxHpActionPoints = new HBox();
		Text IRManaMaxHpActionPointstext = new Text("MaxHP:1200, Mana:800, ActionPoints:7");
		IRManaMaxHpActionPoints.getChildren().add(IRManaMaxHpActionPointstext);
		HBox IRSpeedRangeDamage = new HBox();
		Text IRSpeedRangeDamagetext = new Text("speed:85, Range:3, Damage:90");
		IRSpeedRangeDamage.getChildren().add(IRSpeedRangeDamagetext);
		HBox IRAbilities = new HBox();
		Text IRAbilitiestext = new Text("Ability1:Unibeam, Ability2:3000");
		IRAbilities.getChildren().add(IRAbilitiestext);
		HBox IRAbility = new HBox();
		Text IRAbilitytext = new Text("Ability3:I am Ironma");
		IRAbility.getChildren().add(IRAbilitytext);
		VBox IRvertical = new VBox();
		IRvertical.getChildren().addAll(IRNameType, IRManaMaxHpActionPoints, IRSpeedRangeDamage, IRAbilities,
				IRAbility);

		HBox SPNameType = new HBox();
		Text SPNameTypetext = new Text("Name:Spiderman, Type:Hero");
		SPNameType.getChildren().add(SPNameTypetext);
		HBox SPManaMaxHpActionPoints = new HBox();
		Text SPManaMaxHpActionPointstext = new Text("MaxHP:1400, Mana:750, ActionPoints:7");
		SPManaMaxHpActionPoints.getChildren().add(SPManaMaxHpActionPointstext);
		HBox SPSpeedRangeDamage = new HBox();
		Text SPSpeedRangeDamagetext = new Text("speed:85, Range:1, Damage:120");
		SPSpeedRangeDamage.getChildren().add(SPSpeedRangeDamagetext);
		HBox SPAbilities = new HBox();
		Text SPAbilitiestext = new Text("Ability1:Unibeam, Ability2:3000");
		SPAbilities.getChildren().add(SPAbilitiestext);
		HBox SPAbility = new HBox();
		Text SPAbilitytext = new Text("Ability3:I am Ironma");
		SPAbility.getChildren().add(SPAbilitytext);
		VBox SPvertical = new VBox();
		SPvertical.getChildren().addAll(SPNameType, SPManaMaxHpActionPoints, SPSpeedRangeDamage, SPAbilities,
				SPAbility);

		HBox ELNameType = new HBox();
		Text ELNameTypetext = new Text("Name:Electro, Type:Villain");
		ELNameType.getChildren().add(ELNameTypetext);
		HBox ELManaMaxHpActionPoints = new HBox();
		Text ELManaMaxHpActionPointstext = new Text("MaxHP:1200, Mana:1200, ActionPoints:5");
		ELManaMaxHpActionPoints.getChildren().add(ELManaMaxHpActionPointstext);
		HBox ELSpeedRangeDamage = new HBox();
		Text ELSpeedRangeDamagetext = new Text("speed:75, Range:3, Damage:110");
		ELSpeedRangeDamage.getChildren().add(ELSpeedRangeDamagetext);
		HBox ELAbilities = new HBox();
		Text ELAbilitiestext = new Text("Ability1:Fully Charged, Ability2:EMP");
		ELAbilities.getChildren().add(ELAbilitiestext);
		HBox ELAbility = new HBox();
		Text ELAbilitytext = new Text("Ability3:Lightning Strike Ability");
		ELAbility.getChildren().add(ELAbilitytext);
		VBox ELvertical = new VBox();
		ELvertical.getChildren().addAll(ELNameType, ELManaMaxHpActionPoints, ELSpeedRangeDamage, ELAbilities,
				ELAbility);

		HBox LONameType = new HBox();
		Text LONameTypetext = new Text("Name:loki, Type:Villain");
		LONameType.getChildren().add(LONameTypetext);
		HBox LOManaMaxHpActionPoints = new HBox();
		Text LOManaMaxHpActionPointstext = new Text("MaxHP:1150, Mana:900, ActionPoints:5");
		LOManaMaxHpActionPoints.getChildren().add(LOManaMaxHpActionPointstext);
		HBox LOSpeedRangeDamage = new HBox();
		Text LOSpeedRangeDamagetext = new Text("speed:70, Range:1, Damage:150");
		LOSpeedRangeDamage.getChildren().add(LOSpeedRangeDamagetext);
		HBox LOAbilities = new HBox();
		Text LOAbilitiestext = new Text("Ability1:God of Mischief, Ability2:Fake Death");
		LOAbilities.getChildren().add(LOAbilitiestext);
		HBox LOAbility = new HBox();
		Text LOAbilitytext = new Text("Ability3:The Hidden Dagger Ability");
		LOAbility.getChildren().add(LOAbilitytext);
		VBox LOvertical = new VBox();
		LOvertical.getChildren().addAll(LONameType, LOManaMaxHpActionPoints, LOSpeedRangeDamage, LOAbilities,
				LOAbility);

		HBox QNameType = new HBox();
		Text QNameTypetext = new Text("Name:Quick Silver, Type:Villain");
		QNameType.getChildren().add(QNameTypetext);
		HBox QManaMaxHpActionPoints = new HBox();
		Text QManaMaxHpActionPointstext = new Text("MaxHP:1200, Mana:650, ActionPoints:8");
		QManaMaxHpActionPoints.getChildren().add(QManaMaxHpActionPointstext);
		HBox QSpeedRangeDamage = new HBox();
		Text QSpeedRangeDamagetext = new Text("speed:99, Range:1, Damage:70");
		QSpeedRangeDamage.getChildren().add(QSpeedRangeDamagetext);
		HBox QAbilities = new HBox();
		Text QAbilitiestext = new Text("Ability1:Time in a bottle, Ability2:Good as new");
		QAbilities.getChildren().add(QAbilitiestext);
		HBox QAbility = new HBox();
		Text QAbilitytext = new Text("Ability3:1 sec 100 punch Ability");
		QAbility.getChildren().add(QAbilitytext);
		VBox Qvertical = new VBox();
		Qvertical.getChildren().addAll(QNameType, QManaMaxHpActionPoints, QSpeedRangeDamage, QAbilities, QAbility);

		HBox YNameType = new HBox();
		Text YNameTypetext = new Text("Name:Yellow Jacket, Type:Villain");
		YNameType.getChildren().add(YNameTypetext);
		HBox YManaMaxHpActionPoints = new HBox();
		Text YManaMaxHpActionPointstext = new Text("MaxHP:1050, Mana:800, ActionPoints:6");
		YManaMaxHpActionPoints.getChildren().add(YManaMaxHpActionPointstext);
		HBox YSpeedRangeDamage = new HBox();
		Text YSpeedRangeDamagetext = new Text("speed:60, Range:2, Damage:80");
		YSpeedRangeDamage.getChildren().add(YSpeedRangeDamagetext);
		HBox YAbilities = new HBox();
		Text YAbilitiestext = new Text("Ability1:Laser Sting, Ability2:QuANTaMANia");
		YAbilities.getChildren().add(YAbilitiestext);
		HBox YAbility = new HBox();
		Text YAbilitytext = new Text("Ability3:Pym Particle Upsize");
		YAbility.getChildren().add(YAbilitytext);
		VBox Yvertical = new VBox();
		Yvertical.getChildren().addAll(YNameType, YManaMaxHpActionPoints, YSpeedRangeDamage, YAbilities, YAbility);

		HBox DNameType = new HBox();
		Text DNameTypetext = new Text("Name:Deadpool, Type:AntiHero");
		DNameType.getChildren().add(DNameTypetext);
		HBox DManaMaxHpActionPoints = new HBox();
		Text DManaMaxHpActionPointstext = new Text("MaxHP:1350, Mana:700, ActionPoints:6");
		DManaMaxHpActionPoints.getChildren().add(DManaMaxHpActionPointstext);
		HBox DSpeedRangeDamage = new HBox();
		Text DSpeedRangeDamagetext = new Text("speed:80, Range:3, Damage:90");
		DSpeedRangeDamage.getChildren().add(DSpeedRangeDamagetext);
		HBox DAbilities = new HBox();
		Text DAbilitiestext = new Text("Ability1:Try Harder, Ability2:8 bullets left");
		DAbilities.getChildren().add(DAbilitiestext);
		HBox DAbility = new HBox();
		Text DAbilitytext = new Text("Ability3:Can't Catch Me");
		DAbility.getChildren().add(DAbilitytext);
		VBox Dvertical = new VBox();
		Dvertical.getChildren().addAll(DNameType, DManaMaxHpActionPoints, DSpeedRangeDamage, DAbilities, DAbility);

		HBox HNameType = new HBox();
		Text HNameTypetext = new Text("Name:Hela, Type:AntiHero");
		HNameType.getChildren().add(HNameTypetext);
		HBox HManaMaxHpActionPoints = new HBox();
		Text HManaMaxHpActionPointstext = new Text("MaxHP:1500, Mana:750, ActionPoints:5");
		HManaMaxHpActionPoints.getChildren().add(HManaMaxHpActionPointstext);
		HBox HSpeedRangeDamage = new HBox();
		Text HSpeedRangeDamagetext = new Text("speed:75, Range:1, Damage:150");
		HSpeedRangeDamage.getChildren().add(HSpeedRangeDamagetext);
		HBox HAbilities = new HBox();
		Text HAbilitiestext = new Text("Ability1:Thorn Shield, Ability2:Thorn Shower");
		HAbilities.getChildren().add(HAbilitiestext);
		HBox HAbility = new HBox();
		Text HAbilitytext = new Text("Ability3:Godess of Death Ability");
		HAbility.getChildren().add(HAbilitytext);
		VBox Hvertical = new VBox();
		Hvertical.getChildren().addAll(HNameType, HManaMaxHpActionPoints, HSpeedRangeDamage, HAbilities, HAbility);
		HBox VNameType = new HBox();

		Text VNameTypetext = new Text("Name:Venom, Type:AntiHero");
		VNameType.getChildren().add(VNameTypetext);
		HBox VManaMaxHpActionPoints = new HBox();
		Text VManaMaxHpActionPointstext = new Text("MaxHP:1650, Mana:700, ActionPoints:5");
		VManaMaxHpActionPoints.getChildren().add(VManaMaxHpActionPointstext);
		HBox VSpeedRangeDamage = new HBox();
		Text VSpeedRangeDamagetext = new Text("speed:70, Range:1, Damage:140");
		VSpeedRangeDamage.getChildren().add(VSpeedRangeDamagetext);
		HBox VAbilities = new HBox();
		Text VAbilitiestext = new Text("Ability1:Head Bite, Ability2:Symbiosis");
		VAbilities.getChildren().add(VAbilitiestext);
		HBox VAbility = new HBox();
		Text VAbilitytext = new Text("Ability3:We are venom");
		VAbility.getChildren().add(VAbilitytext);
		VBox Vvertical = new VBox();
		Vvertical.getChildren().addAll(VNameType, VManaMaxHpActionPoints, VSpeedRangeDamage, VAbilities, VAbility);

		HBox GNameType = new HBox();
		Text GNameTypetext = new Text("Name:Ghost Rider, Type:AntiHero");
		GNameType.getChildren().add(GNameTypetext);
		HBox GManaMaxHpActionPoints = new HBox();
		Text GManaMaxHpActionPointstext = new Text("MaxHP:1800, Mana:600, ActionPoints:6");
		GManaMaxHpActionPoints.getChildren().add(GManaMaxHpActionPointstext);
		HBox GSpeedRangeDamage = new HBox();
		Text GSpeedRangeDamagetext = new Text("speed:85, Range:1, Damage:140");
		GSpeedRangeDamage.getChildren().add(GSpeedRangeDamagetext);
		HBox GAbilities = new HBox();
		Text GAbilitiestext = new Text("Ability1:Death stare, Ability2:Fire Breath");
		GAbilities.getChildren().add(GAbilitiestext);
		HBox GAbility = new HBox();
		Text GAbilitytext = new Text("Ability3:Chain Whip");
		GAbility.getChildren().add(GAbilitytext);
		VBox Gvertical = new VBox();
		Gvertical.getChildren().addAll(GNameType, GManaMaxHpActionPoints, GSpeedRangeDamage, GAbilities, GAbility);

		HBox b1t = new HBox(CaptainAmericavertical, HULKvertical, THORvertical, ICEvertical, DRvertical);
		HBox b2t = new HBox(IRvertical, SPvertical, ELvertical, LOvertical, Qvertical);
		HBox b3t = new HBox(Yvertical, Dvertical, Hvertical, Vvertical, Gvertical);

		b1.setPrefWidth(400);
		b2.setPrefWidth(400);
		b3.setPrefWidth(400);
		b1.setSpacing(65);
		b2.setSpacing(65);
		b3.setSpacing(65);
		b1t.setSpacing(18);
		b2t.setSpacing(18);
		b3t.setSpacing(18);
		Label choosep1 = new Label("Please Choose Three Champions For each Player");
		choosep1.setFont(new Font("Arial", 38));
		VBox Champions = new VBox(choosep1, b1, b1t, b2, b2t, b3, b3t);
		Champions.setPadding(new Insets(30, 30, 30, 30));
		Champions.setSpacing(10);

		Choosing.getChildren().addAll(Champions);
		stage1.setScene(choosingChampions);
	}

	public void ChoosingLeaderSceneMethod() {
		StackPane choosing2 = new StackPane();
		choosingLeader = new Scene(choosing2);

		l1 = new Button();
		l1.setText(game.getFirstPlayer().getTeam().get(0).getName());
		l1.setFont(new Font("Arial", 35));
		l1.setOnAction(this);
		l2 = new Button();
		l2.setText(game.getFirstPlayer().getTeam().get(1).getName());
		l2.setFont(new Font("Arial", 35));
		l2.setOnAction(this);
		l3 = new Button();
		l3.setText(game.getFirstPlayer().getTeam().get(2).getName());
		l3.setFont(new Font("Arial", 35));
		l3.setOnAction(this);
		l1.setGraphic(getImageOfChampionForButton(l1.getText()));
		l2.setGraphic(getImageOfChampionForButton(l2.getText()));
		l3.setGraphic(getImageOfChampionForButton(l3.getText()));
		HBox leaders1 = new HBox();
		leaders1.getChildren().addAll(l1, l2, l3);
		VBox finaleLeader1 = new VBox();
		Label choosep1 = new Label("Choose A Leader for " + game.getFirstPlayer().getName() + "'s team");
		choosep1.setFont(new Font("Arial", 38));
		finaleLeader1.getChildren().addAll(choosep1, leaders1);
		finaleLeader1.setPadding(new Insets(30, 30, 30, 30));
		finaleLeader1.setSpacing(10);

		choosing2.getChildren().addAll(finaleLeader1);
		stage1.setScene(choosingLeader);
	}

	public void ChoosingLeaderScene2Method() {
		StackPane choosing3 = new StackPane();
		choosingLeader2 = new Scene(choosing3);

		l11 = new Button();
		l11.setText(game.getSecondPlayer().getTeam().get(0).getName());
		l11.setFont(new Font("Arial", 35));
		l11.setOnAction(this);
		l22 = new Button();
		l22.setText(game.getSecondPlayer().getTeam().get(1).getName());
		l22.setFont(new Font("Arial", 35));
		l22.setOnAction(this);
		l33 = new Button();
		l33.setText(game.getSecondPlayer().getTeam().get(2).getName());
		l33.setFont(new Font("Arial", 35));
		l33.setOnAction(this);
		l11.setGraphic(getImageOfChampionForButton(l11.getText()));
		l22.setGraphic(getImageOfChampionForButton(l22.getText()));
		l33.setGraphic(getImageOfChampionForButton(l33.getText()));
		HBox leaders2 = new HBox();
		leaders2.getChildren().addAll(l11, l22, l33);
		VBox finaleLeader2 = new VBox();
		Label choosep2 = new Label("Choose A Leader for " + game.getSecondPlayer().getName() + "'s team");
		choosep2.setFont(new Font("Arial", 38));
		finaleLeader2.getChildren().addAll(choosep2, leaders2);
		finaleLeader2.setPadding(new Insets(30, 30, 30, 30));
		finaleLeader2.setSpacing(10);

		choosing3.getChildren().addAll(finaleLeader2);
		stage1.setScene(choosingLeader2);
	}

	public void playSceneMethod() {
		StackPane gameplaying = new StackPane();
		playing = new Scene(gameplaying);

		zero0 = new Button();
		// zero0.setText("(0,0)");
		zero0.setFont(new Font("Arial", 35));
		zero0.setOnAction(this);
		PutChampionOnGrid(zero0, 0, 0);
		zero0.setPrefSize(140, 70);

		zero1 = new Button();
		// zero1.setText("(0,1)");
		zero1.setFont(new Font("Arial", 35));
		zero1.setOnAction(this);
		PutChampionOnGrid(zero1, 0, 1);
		zero1.setPrefSize(140, 70);

		zero2 = new Button();
		// zero2.setText("(0,2)");
		zero2.setFont(new Font("Arial", 35));
		zero2.setOnAction(this);
		PutChampionOnGrid(zero2, 0, 2);
		zero2.setPrefSize(140, 70);

		zero3 = new Button();
		// zero3.setText("(0,3)");
		zero3.setFont(new Font("Arial", 35));
		zero3.setOnAction(this);
		PutChampionOnGrid(zero3, 0, 3);
		zero3.setPrefSize(140, 70);

		zero4 = new Button();
		// zero4.setText("(0,4)");
		zero4.setFont(new Font("Arial", 35));
		zero4.setOnAction(this);
		PutChampionOnGrid(zero4, 0, 4);
		zero4.setPrefSize(140, 70);

		one0 = new Button();
		// one0.setText("(1,0)");
		one0.setFont(new Font("Arial", 35));
		one0.setOnAction(this);
		PutChampionOnGrid(one0, 1, 0);
		one0.setPrefSize(140, 70);

		one1 = new Button();
		// one1.setText("(1,1)");
		one1.setFont(new Font("Arial", 35));
		one1.setOnAction(this);
		PutChampionOnGrid(one1, 1, 1);
		one1.setPrefSize(140, 70);

		one2 = new Button();
		// one2.setText("(1,2)");
		one2.setFont(new Font("Arial", 35));
		one2.setOnAction(this);
		PutChampionOnGrid(one2, 1, 2);
		one2.setPrefSize(140, 70);

		one3 = new Button();
		// one3.setText("(1,3)");
		one3.setFont(new Font("Arial", 35));
		one3.setOnAction(this);
		PutChampionOnGrid(one3, 1, 3);
		one3.setPrefSize(140, 70);

		one4 = new Button();
		// one4.setText("(1,4)");
		one4.setFont(new Font("Arial", 35));
		one4.setOnAction(this);
		PutChampionOnGrid(one4, 1, 4);
		one4.setPrefSize(140, 70);

		two0 = new Button();
		// two0.setText("(2,0)");
		two0.setFont(new Font("Arial", 35));
		two0.setOnAction(this);
		PutChampionOnGrid(two0, 2, 0);
		two0.setPrefSize(140, 70);

		two1 = new Button();
		// two1.setText("(2,1)");
		two1.setFont(new Font("Arial", 35));
		two1.setOnAction(this);
		PutChampionOnGrid(two1, 2, 1);
		two1.setPrefSize(140, 70);

		two2 = new Button();
		// two2.setText("(2,2)");
		two2.setFont(new Font("Arial", 35));
		two2.setOnAction(this);
		PutChampionOnGrid(two2, 2, 2);
		two2.setPrefSize(140, 70);

		two3 = new Button();
		// two3.setText("(2,3)");
		two3.setFont(new Font("Arial", 35));
		two3.setOnAction(this);
		PutChampionOnGrid(two3, 2, 3);
		two3.setPrefSize(140, 70);

		two4 = new Button();
		// two4.setText("(2,4)");
		two4.setFont(new Font("Arial", 35));
		two4.setOnAction(this);
		PutChampionOnGrid(two4, 2, 4);
		two4.setPrefSize(140, 70);

		three0 = new Button();
		// three0.setText("(3,0)");
		three0.setFont(new Font("Arial", 35));
		three0.setOnAction(this);
		PutChampionOnGrid(three0, 3, 0);
		three0.setPrefSize(140, 70);

		three1 = new Button();
		// three1.setText("(3,1)");
		three1.setFont(new Font("Arial", 35));
		three1.setOnAction(this);
		PutChampionOnGrid(three1, 3, 1);
		three1.setPrefSize(140, 70);

		three2 = new Button();
		// three2.setText("(3,2)");
		three2.setFont(new Font("Arial", 35));
		three2.setOnAction(this);
		PutChampionOnGrid(three2, 3, 2);
		three2.setPrefSize(140, 70);

		three3 = new Button();
		// three3.setText("(3,3)");
		three3.setFont(new Font("Arial", 35));
		three3.setOnAction(this);
		PutChampionOnGrid(three3, 3, 3);
		three3.setPrefSize(140, 70);

		three4 = new Button();
		// three4.setText("(3,4)");
		three4.setFont(new Font("Arial", 35));
		three4.setOnAction(this);
		PutChampionOnGrid(three4, 3, 4);
		three4.setPrefSize(140, 70);

		four0 = new Button();
		// four0.setText("(4,0)");
		four0.setFont(new Font("Arial", 35));
		four0.setOnAction(this);
		PutChampionOnGrid(four0, 4, 0);
		four0.setPrefSize(140, 70);

		four1 = new Button();
		// four1.setText("(4,1)");
		four1.setFont(new Font("Arial", 35));
		four1.setOnAction(this);
		PutChampionOnGrid(four1, 4, 1);
		four1.setPrefSize(140, 70);

		four2 = new Button();
		// four2.setText("(4,2)");
		four2.setFont(new Font("Arial", 35));
		four2.setOnAction(this);
		PutChampionOnGrid(four2, 4, 2);
		four2.setPrefSize(140, 70);

		four3 = new Button();
		// four3.setText("(4,3)");
		four3.setFont(new Font("Arial", 35));
		four3.setOnAction(this);
		PutChampionOnGrid(four3, 4, 3);
		four3.setPrefSize(140, 70);

		four4 = new Button();
		// four4.setText("(4,4)");
		four4.setFont(new Font("Arial", 35));
		four4.setOnAction(this);
		PutChampionOnGrid(four4, 4, 4);
		four4.setPrefSize(140, 70);

		GridPane boardonscreen = new GridPane();
		boardonscreen.add(zero0, 0, 4);
		boardonscreen.add(zero1, 1, 4);
		boardonscreen.add(zero2, 2, 4);
		boardonscreen.add(zero3, 3, 4);
		boardonscreen.add(zero4, 4, 4);
		boardonscreen.add(one0, 0, 3);
		boardonscreen.add(one1, 1, 3);
		boardonscreen.add(one2, 2, 3);
		boardonscreen.add(one3, 3, 3);
		boardonscreen.add(one4, 4, 3);
		boardonscreen.add(two0, 0, 2);
		boardonscreen.add(two1, 1, 2);
		boardonscreen.add(two2, 2, 2);
		boardonscreen.add(two3, 3, 2);
		boardonscreen.add(two4, 4, 2);
		boardonscreen.add(three0, 0, 1);
		boardonscreen.add(three1, 1, 1);
		boardonscreen.add(three2, 2, 1);
		boardonscreen.add(three3, 3, 1);
		boardonscreen.add(three4, 4, 1);
		boardonscreen.add(four0, 0, 0);
		boardonscreen.add(four1, 1, 0);
		boardonscreen.add(four2, 2, 0);
		boardonscreen.add(four3, 3, 0);
		boardonscreen.add(four4, 4, 0);
		putCoversOnBoardInGUI(boardonscreen);
		VBox BoxForBoard = new VBox();
		BoxForBoard.getChildren().addAll(boardonscreen);

		UP = new Button();
		UP.setOnAction(this);
		UP.setMinHeight(70);
		UP.setMinWidth(50);
		UP.setGraphic(new ImageView("UP.jpeg"));
		Down = new Button();
		Down.setOnAction(this);
		Down.setMinHeight(70);
		Down.setMinWidth(50);
		Down.setGraphic(new ImageView("Down.jpeg"));
		Right = new Button();
		Right.setOnAction(this);
		Right.setMinHeight(58);
		Right.setMinWidth(80);
		Right.setGraphic(new ImageView("Right.jpeg"));
		Left = new Button();
		Left.setOnAction(this);
		Left.setMinHeight(58);
		Left.setMinWidth(80);
		Left.setGraphic(new ImageView("Left.jpeg"));
		HBox LR = new HBox();
		LR.getChildren().addAll(Left, Right);
		VBox buttons = new VBox();
		EndTurn = new Button();
		EndTurn.setOnAction(this);
		EndTurn.setText("EndTurn");
		EndTurn.setMinHeight(40);
		EndTurn.setMinWidth(160);
		buttons.getChildren().addAll(UP, LR, Down, EndTurn);
		LR.setAlignment(Pos.CENTER);
		buttons.setAlignment(Pos.CENTER);
		boardonscreen.add(buttons, 5, 0, 1, 2);

		attackUp = new Button();
		attackUp.setOnAction(this);
		attackUp.setMinHeight(70);
		attackUp.setMinWidth(50);
		attackUp.setText("AttackUp");
		attackDown = new Button();
		attackDown.setOnAction(this);
		attackDown.setMinHeight(70);
		attackDown.setMinWidth(50);
		attackDown.setText("AttackDown");
		attackRight = new Button();
		attackRight.setOnAction(this);
		attackRight.setMinHeight(58);
		attackRight.setMinWidth(80);
		attackRight.setText("AttackRight");
		attackLeft = new Button();
		attackLeft.setOnAction(this);
		attackLeft.setMinHeight(58);
		attackLeft.setMinWidth(80);
		attackLeft.setText("AttackLeft");
		HBox ALAR = new HBox();
		ALAR.getChildren().addAll(attackLeft, attackRight);
		VBox attackbuttons = new VBox();
		attackbuttons.getChildren().addAll(attackUp, ALAR, attackDown);
		ALAR.setAlignment(Pos.CENTER);
		attackbuttons.setAlignment(Pos.CENTER);
		boardonscreen.add(attackbuttons, 5, 2, 1, 1);

		Text Player1 = new Text("PlayerName: " + game.getFirstPlayer().getName());
		HBox Player1b = new HBox(Player1);
		boardonscreen.add(Player1b, 6, 0);
		VBox detailsofp1 = new VBox();
		detailsofp1.getChildren().add(Player1b);
		Text LAused1 = new Text();
		if (game.isFirstLeaderAbilityUsed())
			LAused1 = new Text("LeaderAbilityUsed: Yes");
		else
			LAused1 = new Text("LeaderAbilityUsed: No");
		HBox LAused1B = new HBox(LAused1);
		for (int i = 0; i < game.getFirstPlayer().getTeam().size(); i++) {
			Text player1Champ = new Text("Champ" + (i + 1) + ": " + game.getFirstPlayer().getTeam().get(i).getName());
			HBox player1Champbox = new HBox(player1Champ);
			detailsofp1.getChildren().add(player1Champbox);
		}
		detailsofp1.getChildren().add(LAused1B);
		boardonscreen.add(detailsofp1, 6, 0);
		for (int i = 0; i < game.getFirstPlayer().getTeam().size(); i++) {
			String type = "";
			String appEff = "";
			Champion temp = game.getFirstPlayer().getTeam().get(i);
			Boolean leaderOrnot = false;
			if (temp.equals(game.getFirstPlayer().getLeader()))
				leaderOrnot = true;
			if (game.getFirstPlayer().getTeam().get(i) instanceof Hero)
				type = "Hero";
			else if (game.getFirstPlayer().getTeam().get(i) instanceof AntiHero)
				type = "AntiHero";
			else
				type = "Villain";
			for (int j = 0; j < temp.getAppliedEffects().size(); j++) {
				appEff = appEff + temp.getAppliedEffects().get(j).getName() + ","
						+ temp.getAppliedEffects().get(j).getDuration() + "\n";
			}
			Text Champ = new Text("Name:" + temp.getName() + "\n" + "Type:" + type + "\n" + "CurrentHp:"
					+ temp.getCurrentHP() + "\n" + "Mana:" + temp.getMana() + "\n" + "Speed:" + temp.getSpeed() + "\n"
					+ "MaxActPerTurn:" + temp.getMaxActionPointsPerTurn() + "\n" + "AttackDamage:"
					+ temp.getAttackDamage() + "\n" + "AttackRange:" + temp.getAttackRange() + "\n" + "AppliedEffects:"
					+ appEff + "\n" + "LeaderOfHisTeam:" + leaderOrnot);
			if (i == 1)
				Champ.setFill(Color.BLUE);
			boardonscreen.add(Champ, 6, i + 1);
		}

		Text Player2 = new Text("PlayerName: " + game.getSecondPlayer().getName());
		HBox Player2b = new HBox(Player2);
		VBox detailsofp2 = new VBox();
		detailsofp2.getChildren().add(Player2b);
		Text LAused = new Text();
		if (game.isSecondLeaderAbilityUsed())
			LAused = new Text("LeaderAbilityUsed: Yes");
		else
			LAused = new Text("LeaderAbilityUsed: No");
		HBox LAusedB = new HBox(LAused);
		for (int i = 0; i < game.getSecondPlayer().getTeam().size(); i++) {
			Text player2Champ = new Text("Champ" + (i + 1) + ": " + game.getSecondPlayer().getTeam().get(i).getName());
			HBox player2Champbox = new HBox(player2Champ);
			detailsofp2.getChildren().add(player2Champbox);
		}
		detailsofp2.getChildren().add(LAusedB);
		boardonscreen.add(detailsofp2, 7, 0);
		for (int i = 0; i < game.getSecondPlayer().getTeam().size(); i++) {
			String type = "";
			String appEff = "";
			Champion temp = game.getSecondPlayer().getTeam().get(i);
			Boolean leaderOrnot = false;
			if (temp.equals(game.getSecondPlayer().getLeader()))
				leaderOrnot = true;
			if (game.getSecondPlayer().getTeam().get(i) instanceof Hero)
				type = "Hero";
			else if (game.getSecondPlayer().getTeam().get(i) instanceof AntiHero)
				type = "AntiHero";
			else
				type = "Villain";
			for (int j = 0; j < temp.getAppliedEffects().size(); j++) {
				appEff = appEff + temp.getAppliedEffects().get(j).getName() + ","
						+ temp.getAppliedEffects().get(j).getDuration() + "\n";
			}
			Text Champ = new Text("Name:" + temp.getName() + "\n" + "Type:" + type + "\n" + "CurrentHp:"
					+ temp.getCurrentHP() + "\n" + "Mana:" + temp.getMana() + "\n" + "Speed:" + temp.getSpeed() + "\n"
					+ "MaxActPerTurn:" + temp.getMaxActionPointsPerTurn() + "\n" + "AttackDamage:"
					+ temp.getAttackDamage() + "\n" + "AttackRange:" + temp.getAttackRange() + "\n" + "AppliedEffects:"
					+ appEff + "\n" + "LeaderOfHisTeam:" + leaderOrnot);
			if (i == 1)
				Champ.setFill(Color.RED);
			boardonscreen.add(Champ, 7, i + 1);
		}

		for (int i = 0; i < 1; i++) {
			String type = "";
			String appEff = "";
			Champion temp = game.getCurrentChampion();
			if (temp instanceof Hero)
				type = "Hero";
			else if (temp instanceof AntiHero)
				type = "AntiHero";
			else
				type = "Villain";
			for (int j = 0; j < temp.getAppliedEffects().size(); j++) {
				appEff = appEff + temp.getAppliedEffects().get(j).getName() + ","
						+ temp.getAppliedEffects().get(j).getDuration() + "\n";
			}
			Text Champ = new Text("CurrentChamp" + "\n" + "Name:" + temp.getName() + "\n" + "Type:" + type + "\n"
					+ "CurrentHp:" + temp.getCurrentHP() + "\n" + "Mana:" + temp.getMana() + "\n" + "CurrActPoints:"
					+ temp.getCurrentActionPoints() + "\n" + "AttackDamage:" + temp.getAttackDamage() + "\n"
					+ "AttackRange:" + temp.getAttackRange() + "\n" + "AppliedEffects:" + appEff + "\n" + "Ability1:"
					+ temp.getAbilities().get(0).getName() + "\n" + "Ability2:" + temp.getAbilities().get(1).getName()
					+ "\n" + "Ability3:" + temp.getAbilities().get(2).getName());
			boardonscreen.add(Champ, 5, 3, 1, 2);
			Ability a1 = temp.getAbilities().get(0);
			String a1type;
			if (a1 instanceof DamagingAbility) {
				a1type = "DamagingAbility";
				Ability1 = new Button("Abilityname:" + a1.getName() + "\n" + "type:" + a1type + "\n" + "AreaOfEffect:"
						+ a1.getCastArea() + "\n" + "CastRange:" + a1.getCastRange() + "\n" + "RequiredMana:"
						+ a1.getManaCost() + "\n" + "reqActionPoints:" + a1.getRequiredActionPoints() + "\n"
						+ "CurrCoolDown:" + a1.getCurrentCooldown() + "\n" + "BaseCoolDown:" + a1.getBaseCooldown()
						+ "\n" + "DamagingAmount:" + ((DamagingAbility) (a1)).getDamageAmount());
			} else if (a1 instanceof CrowdControlAbility) {
				a1type = "CrowdControlAbility";
				Ability1 = new Button("Abilityname:" + a1.getName() + "\n" + "type:" + a1type + "\n" + "AreaOfEffect:"
						+ a1.getCastArea() + "\n" + "CastRange:" + a1.getCastRange() + "\n" + "RequiredMana:"
						+ a1.getManaCost() + "\n" + "reqActionPoints:" + a1.getRequiredActionPoints() + "\n"
						+ "CurrCoolDown:" + a1.getCurrentCooldown() + "\n" + "BaseCoolDown:" + a1.getBaseCooldown()
						+ "\n" + "EffectName:" + ((CrowdControlAbility) (a1)).getEffect().getName() + "\n"
						+ "EffectDur:" + ((CrowdControlAbility) (a1)).getEffect().getDuration());
			} else {
				a1type = "healingAbility";
				Ability1 = new Button("Abilityname:" + a1.getName() + "\n" + "type:" + a1type + "\n" + "AreaOfEffect:"
						+ a1.getCastArea() + "\n" + "CastRange:" + a1.getCastRange() + "\n" + "RequiredMana:"
						+ a1.getManaCost() + "\n" + "reqActionPoints:" + a1.getRequiredActionPoints() + "\n"
						+ "CurrCoolDown:" + a1.getCurrentCooldown() + "\n" + "BaseCoolDown:" + a1.getBaseCooldown()
						+ "\n" + "HealingAmount:" + ((HealingAbility) (a1)).getHealAmount());
			}
			Ability1.setFont(new Font("Arial", 10));
			Ability1.setOnAction(this);
			boardonscreen.add(Ability1, 8, 0);
			Ability a2 = temp.getAbilities().get(1);
			String a2type;
			if (a2 instanceof DamagingAbility) {
				a2type = "DamagingAbility";
				Ability2 = new Button("Abilityname:" + a2.getName() + "\n" + "type:" + a2type + "\n" + "AreaOfEffect:"
						+ a2.getCastArea() + "\n" + "CastRange:" + a2.getCastRange() + "\n" + "RequiredMana:"
						+ a2.getManaCost() + "\n" + "reqActionPoints:" + a2.getRequiredActionPoints() + "\n"
						+ "CurrCoolDown:" + a2.getCurrentCooldown() + "\n" + "BaseCoolDown:" + a2.getBaseCooldown()
						+ "\n" + "DamagingAmount:" + ((DamagingAbility) (a2)).getDamageAmount());
			} else if (a2 instanceof CrowdControlAbility) {
				a2type = "CrowdControlAbility";
				Ability2 = new Button("Abilityname:" + a2.getName() + "\n" + "type:" + a2type + "\n" + "AreaOfEffect:"
						+ a2.getCastArea() + "\n" + "CastRange:" + a2.getCastRange() + "\n" + "RequiredMana:"
						+ a2.getManaCost() + "\n" + "reqActionPoints:" + a2.getRequiredActionPoints() + "\n"
						+ "CurrCoolDown:" + a2.getCurrentCooldown() + "\n" + "BaseCoolDown:" + a2.getBaseCooldown()
						+ "\n" + "EffectName:" + ((CrowdControlAbility) (a2)).getEffect().getName() + "\n"
						+ "EffectDur:" + ((CrowdControlAbility) (a2)).getEffect().getDuration());
			} else {
				a2type = "healingAbility";
				Ability2 = new Button("Abilityname:" + a2.getName() + "\n" + "type:" + a2type + "\n" + "AreaOfEffect:"
						+ a2.getCastArea() + "\n" + "CastRange:" + a2.getCastRange() + "\n" + "RequiredMana:"
						+ a2.getManaCost() + "\n" + "reqActionPoints:" + a2.getRequiredActionPoints() + "\n"
						+ "CurrCoolDown:" + a2.getCurrentCooldown() + "\n" + "BaseCoolDown:" + a2.getBaseCooldown()
						+ "\n" + "HealingAmount:" + ((HealingAbility) (a2)).getHealAmount());
			}
			Ability2.setFont(new Font("Arial", 10));
			Ability2.setOnAction(this);
			boardonscreen.add(Ability2, 8, 1);
			Ability a3 = temp.getAbilities().get(2);
			String a3type;
			if (a3 instanceof DamagingAbility) {
				a3type = "DamagingAbility";
				Ability3 = new Button("Abilityname:" + a3.getName() + "\n" + "type:" + a3type + "\n" + "AreaOfEffect:"
						+ a3.getCastArea() + "\n" + "CastRange:" + a3.getCastRange() + "\n" + "RequiredMana:"
						+ a3.getManaCost() + "\n" + "reqActionPoints:" + a3.getRequiredActionPoints() + "\n"
						+ "CurrCoolDown:" + a3.getCurrentCooldown() + "\n" + "BaseCoolDown:" + a3.getBaseCooldown()
						+ "\n" + "DamagingAmount:" + ((DamagingAbility) (a3)).getDamageAmount());
			} else if (a3 instanceof CrowdControlAbility) {
				a3type = "CrowdControlAbility";
				Ability3 = new Button("Abilityname:" + a3.getName() + "\n" + "type:" + a3type + "\n" + "AreaOfEffect:"
						+ a3.getCastArea() + "\n" + "CastRange:" + a3.getCastRange() + "\n" + "RequiredMana:"
						+ a3.getManaCost() + "\n" + "reqActionPoints:" + a3.getRequiredActionPoints() + "\n"
						+ "CurrCoolDown:" + a3.getCurrentCooldown() + "\n" + "BaseCoolDown:" + a3.getBaseCooldown()
						+ "\n" + "EffectName:" + ((CrowdControlAbility) (a3)).getEffect().getName() + "\n"
						+ "EffectDur:" + ((CrowdControlAbility) (a3)).getEffect().getDuration());
			} else {
				a3type = "healingAbility";
				Ability3 = new Button("Abilityname:" + a3.getName() + "\n" + "type:" + a3type + "\n" + "AreaOfEffect:"
						+ a3.getCastArea() + "\n" + "CastRange:" + a3.getCastRange() + "\n" + "RequiredMana:"
						+ a3.getManaCost() + "\n" + "reqActionPoints:" + a3.getRequiredActionPoints() + "\n"
						+ "CurrCoolDown:" + a3.getCurrentCooldown() + "\n" + "BaseCoolDown:" + a3.getBaseCooldown()
						+ "\n" + "HealingAmount:" + ((HealingAbility) (a3)).getHealAmount());
			}
			Ability3.setFont(new Font("Arial", 10));
			Ability3.setOnAction(this);
			boardonscreen.add(Ability3, 8, 2);
		}

		LeaderAbility1 = new Button(game.getFirstPlayer().getLeader().getName() + "'s Leader Ability");
		LeaderAbility1.setFont(new Font("Arial", 10));
		LeaderAbility1.setOnAction(this);
		LeaderAbility1.setPrefSize(140, 70);
		boardonscreen.add(LeaderAbility1, 6, 4);

		LeaderAbility2 = new Button(game.getSecondPlayer().getLeader().getName() + "'s Leader Ability");
		LeaderAbility2.setFont(new Font("Arial", 10));
		LeaderAbility2.setOnAction(this);
		LeaderAbility2.setPrefSize(140, 70);
		boardonscreen.add(LeaderAbility2, 7, 4);

		Label PQ = new Label(DisplayPQ(game.getTurnOrder()));
		PQ.setFont(new Font("Arial", 30));
		boardonscreen.add(PQ, 0, 5, 5, 1);

		boardonscreen.setHgap(1);
		// boardonscreen.setVgap(1);
		gameplaying.getChildren().addAll(BoxForBoard);
		stage1.setScene(playing);
	}

	public void putCoversOnBoardInGUI(GridPane GP) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (game.getBoard()[i][j] instanceof Cover) {
					HBox y1 = new HBox();
					HBox y2 = new HBox();
					VBox y3 = new VBox();
					y3.getChildren().addAll(y1, y2);
					y3.setSpacing(10);
					int currhp = ((Cover) (game.getBoard()[i][j])).getCurrentHP();
					Label x = new Label("CurrentHp: " + currhp + "");
					x.setFont(new Font("Arial", 15));
					y1.getChildren().add(x);
					ImageView image = new ImageView("obstacle4.jpg");
					y2.getChildren().add(image);
					Point p = getPointOfBoardOnGridPane(i, j);
					GP.add(y3, (int) p.getX(), (int) p.getY());
				}
			}
		}
	}

	public void PutChampionOnGrid(Button z, int x, int y) {
		if (game.getBoard()[x][y] instanceof Champion) {
			z.setGraphic(getImageOfChampionForButton(((Champion) (game.getBoard()[x][y])).getName()));
		}
	}
	

	public Point getPointOfBoardOnGridPane(int x, int y) {
		Point temp = new Point(x, y);
		temp.x = y;
		if (x == 0) {
			temp.y = 4;
		} else if (x == 1) {
			temp.y = 3;
		} else if (x == 2) {
			temp.y = 2;
		} else if (x == 3) {
			temp.y = 1;
		} else if (x == 4) {
			temp.y = 0;
		}
		return temp;
	}

	public ImageView getImageOfChampionForButton(String s) {
		ImageView temp = null;
		if (s.equals("Captain America"))
			temp = new ImageView("Captain America fs.jpg");
		else if (s.equals("Hulk"))
			temp = new ImageView("Hulk.jpg");
		else if (s.equals("Thor"))
			temp = new ImageView("THOR.jpg");
		else if (s.equals("Iceman"))
			temp = new ImageView("Iceman.jpg");
		else if (s.equals("Dr Strange"))
			temp = new ImageView("strange.jpg");
		else if (s.equals("Hela"))
			temp = new ImageView("hela.jpg");
		else if (s.equals("Deadpool"))
			temp = new ImageView("dead.jpg");
		else if (s.equals("Electro"))
			temp = new ImageView("Electro.jpg");
		else if (s.equals("Ghost Rider"))
			temp = new ImageView("ghost.jpg");
		else if (s.equals("Ironman"))
			temp = new ImageView("ironman.jpg");
		else if (s.equals("Loki"))
			temp = new ImageView("loki.jpg");
		else if (s.equals("Quicksilver"))
			temp = new ImageView("Quick.jpg");
		else if (s.equals("Spiderman"))
			temp = new ImageView("SpiderMna.jpg");
		else if (s.equals("Venom"))
			temp = new ImageView("venom.jpg");
		else
			temp = new ImageView("yellow.jpg");
		return temp;
	}

	public static Game creatingGame(String name1, String name2) {
		Player player1 = new Player(name1);
		Player player2 = new Player(name2);
		Game game = new Game(player1, player2);
		return game;
	}

	public static Champion playerTeam(String ch1, Game game) {
		Champion temp = null;
		for (int i = 0; i < game.getAvailableChampions().size(); i++) {
			if (game.getAvailableChampions().get(i).getName().equals(ch1)) {
				temp = game.getAvailableChampions().get(i);
			}
		}
		return temp;
	}

	public String DisplayPQ(PriorityQueue T) {
		PriorityQueue temp = new PriorityQueue(6);
		String s = "";
		while (!T.isEmpty()) {
			s = s + ((Champion) T.peekMin()).getName() + " , ";
			temp.insert(T.remove());
		}
		while (!temp.isEmpty()) {
			T.insert(temp.remove());
		}
		return s;
	}
}
