package cosc250.boids

import scala.collection.immutable.Queue

/** Holds the replay buffer for our simulation.
  *
  * @param queue
  *   \- the queue of frames that is the memory
  * @param max
  *   \- the max number of frames to hold
  */
class FrameMemory(queue: Queue[SimulationFrame], max: Int) {

  /** An alternative constructor, so we can say FrameMemory(startFrame,
    * maxFrames)
    */
  def this(startFrame: SimulationFrame, max: Int) = this(Queue(startFrame), max)

  def currentFrame: SimulationFrame =
    // Remember, items join queues at the back.
    {
      this.queue.front
    }

  def oldestFrame: SimulationFrame = {
    this.queue.last
  }

  def pushFrame(frame: SimulationFrame): FrameMemory = {
    return FrameMemory((this.queue.enqueue(frame)).dequeue._2, max)
    // returns a FrameMemory that has a new frame and the last frame popped off
  }
}
