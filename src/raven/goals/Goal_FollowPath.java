package raven.goals;

import java.util.ArrayList;
import java.util.Iterator;

import raven.game.RavenBot;
import raven.game.navigation.NavGraphEdge;
import raven.math.Vector2D;
import raven.math.graph.GraphEdge;
import raven.ui.GameCanvas;

public class Goal_FollowPath extends GoalComposite<RavenBot> {

	private ArrayList<NavGraphEdge>  m_Path = new ArrayList<NavGraphEdge>();




	public Goal_FollowPath(RavenBot m_pOwner, ArrayList<NavGraphEdge> list) {
		this.setM_pOwner(m_pOwner);
		this.m_Path = list;
	}


	void activate() {
		m_iStatus = Goal.curStatus.active;

		//get a reference to the next edge
		GraphEdge edge = m_Path.get(0);

		//remove the edge from the path
		m_Path.remove(0); 

		//some edges specify that the bot should use a specific behavior when
		//following them. This switch statement queries the edge behavior flag and
		//adds the appropriate goals/s to the subgoal list.
		/*switch(edge.behavior())
		{
		case normal:
		{
			AddSubgoal(new Goal_TraverseEdge(getM_pOwner(), edge, m_Path.isEmpty()));
		}

		break;

		case GraphEdge.goesThroughDoor:
		{

			//also add a goal that is able to handle opening the door
			AddSubgoal(new Goal_NegotiateDoor(getM_pOwner(), edge, m_Path.isEmpty()));
		}

		break;

		case GraphEdge.jump:
		{
			//add subgoal to jump along the edge
			// not defined in c++ code...
		}

		break;

		case GraphEdge.grapple:
		{
			//add subgoal to grapple along the edge
			// not defined in c++ code
		}

		break;

		default:

			throw new Exception("<Goal_FollowPath::Activate>: Unrecognized edge type");
		}

*/

	}
	public raven.goals.Goal.curStatus process() {
		 //if status is inactive, call Activate()
		  activateIfInactive();

		  m_iStatus = ProcessSubgoals();

		  //if there are no subgoals present check to see if the path still has edges.
		  //remaining. If it does then call activate to grab the next edge.
		  if (m_iStatus == Goal.curStatus.completed && !m_Path.isEmpty())
		  {
		    Activate(); 
		  }

		  return m_iStatus;
	}
	public void render() {
		
		// dont under stand this one, and don't want to break it this is what i had.
//		  //render all the path waypoints remaining on the path list
//		  Iterator<NavGraphEdge> it = m_Path.iterator();
//          GraphEdge temp = new GraphEdge();
//		  while(it.hasNext())
//		  {  
//			  temp = it.next();
//		    GameCanvas.blackPen();
//		    GameCanvas.lineWithArrow(temp.from()), temp.to(), 5);
//		    
//		    GameCanvas.redBrush();
//		    GameCanvas.blackPen();
//		    GameCanvas.Circle(temp.Destination(), 3);
//		  }
//
//		  //forward the request to the subgoals
//		  Goal_Composite<Raven_Bot>::Render();
//		
		
	}
	public void terminate(){// do nothing?

	}

	@Override
	public void renderAtPos(Vector2D p) {
		//do nothing

	}



}