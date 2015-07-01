/*
 * IronJacamar, a Java EE Connector Architecture implementation
 * Copyright 2014, Red Hat Inc, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.jca.adapters.jdbc.jdk8;

import org.jboss.jca.adapters.jdbc.WrappedResultSet;
import org.jboss.jca.adapters.jdbc.WrappedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * WrappedStatementJDK8.
 * 
 * @author <a href="jesper.pedersen@ironjacamar.org">Jesper Pedersen</a>
 */
public class WrappedStatementJDK8 extends WrappedStatement
{
   private static final long serialVersionUID = 1L;

   /**
    * Constructor
    * @param lc The connection
    * @param s The statement
    * @param spy The spy value
    * @param jndiName The jndi name
    * @param doLocking Do locking
    */
   public WrappedStatementJDK8(WrappedConnectionJDK8 lc, Statement s, boolean spy, String jndiName,
                               boolean doLocking)
   {
      super(lc, s, spy, jndiName, doLocking);
   }

   /**
    * Wrap ResultSet
    * @param resultSet The ResultSet
    * @param spy The spy value
    * @param jndiName The jndi name
    * @param doLocking Do locking
    * @return The result
    */
   protected WrappedResultSet wrapResultSet(ResultSet resultSet, boolean spy, String jndiName,
                                            boolean doLocking)
   {
      return new WrappedResultSetJDK8(this, resultSet, spy, jndiName, doLocking);
   }

   /**
    * {@inheritDoc}
    */
   public long getLargeUpdateCount()
      throws SQLException
   {
      if (doLocking)
         lock();
      try
      {
         checkState();
         try
         {
            if (spy)
               spyLogger.debugf("%s [%s] getLargeUpdateCount()",
                                jndiName, spyLoggingCategory);

            return getWrappedObject().getLargeUpdateCount();
         }
         catch (Throwable t)
         {
            throw checkException(t);
         }
      }
      finally
      {
         if (doLocking)
            unlock();
      }
   }

   /**
    * {@inheritDoc}
    */
   public void setLargeMaxRows(long max)
      throws SQLException
   {
      if (doLocking)
         lock();
      try
      {
         checkState();
         try
         {
            if (spy)
               spyLogger.debugf("%s [%s] setLargeMaxRows(%d)",
                                jndiName, spyLoggingCategory,
                                max);

            getWrappedObject().setLargeMaxRows(max);
         }
         catch (Throwable t)
         {
            throw checkException(t);
         }
      }
      finally
      {
         if (doLocking)
            unlock();
      }
   }

   /**
    * {@inheritDoc}
    */
   public long getLargeMaxRows()
      throws SQLException
   {
      if (doLocking)
         lock();
      try
      {
         checkState();
         try
         {
            if (spy)
               spyLogger.debugf("%s [%s] getLargeMaxRows()",
                                jndiName, spyLoggingCategory);

            return getWrappedObject().getLargeMaxRows();
         }
         catch (Throwable t)
         {
            throw checkException(t);
         }
      }
      finally
      {
         if (doLocking)
            unlock();
      }
   }

   /**
    * {@inheritDoc}
    */
   public long[] executeLargeBatch()
      throws SQLException
   {
      if (doLocking)
         lock();
      try
      {
         checkTransaction();
         try
         {
            if (spy)
               spyLogger.debugf("%s [%s] executeLargeBatch()",
                                jndiName, spyLoggingCategory);

            return getWrappedObject().executeLargeBatch();
         }
         catch (Throwable t)
         {
            throw checkException(t);
         }
      }
      finally
      {
         if (doLocking)
            unlock();
      }
   }

   /**
    * {@inheritDoc}
    */
   public long executeLargeUpdate(String sql)
      throws SQLException
   {
      if (doLocking)
         lock();
      try
      {
         checkTransaction();
         try
         {
            if (spy)
               spyLogger.debugf("%s [%s] executeLargeUpdate(%s)",
                                jndiName, spyLoggingCategory,
                                sql);

            return getWrappedObject().executeLargeUpdate(sql);
         }
         catch (Throwable t)
         {
            throw checkException(t);
         }
      }
      finally
      {
         if (doLocking)
            unlock();
      }
   }

   /**
    * {@inheritDoc}
    */
   public long executeLargeUpdate(String sql,
                                  int autoGeneratedKeys)
      throws SQLException
   {
      if (doLocking)
         lock();
      try
      {
         checkTransaction();
         try
         {
            if (spy)
               spyLogger.debugf("%s [%s] executeLargeUpdate(%s, %d)",
                                jndiName, spyLoggingCategory,
                                sql, autoGeneratedKeys);

            return getWrappedObject().executeLargeUpdate(sql, autoGeneratedKeys);
         }
         catch (Throwable t)
         {
            throw checkException(t);
         }
      }
      finally
      {
         if (doLocking)
            unlock();
      }
   }

   /**
    * {@inheritDoc}
    */
   public long executeLargeUpdate(String sql,
                                  int[] columnIndexes)
      throws SQLException
   {
      if (doLocking)
         lock();
      try
      {
         checkTransaction();
         try
         {
            if (spy)
               spyLogger.debugf("%s [%s] executeLargeUpdate(%s, %s)",
                                jndiName, spyLoggingCategory,
                                sql, columnIndexes);

            return getWrappedObject().executeLargeUpdate(sql, columnIndexes);
         }
         catch (Throwable t)
         {
            throw checkException(t);
         }
      }
      finally
      {
         if (doLocking)
            unlock();
      }
   }

   /**
    * {@inheritDoc}
    */
   public long executeLargeUpdate(String sql,
                                  String[] columnNames)
      throws SQLException
   {
      if (doLocking)
         lock();
      try
      {
         checkTransaction();
         try
         {
            if (spy)
               spyLogger.debugf("%s [%s] executeLargeUpdate(%s, %s)",
                                jndiName, spyLoggingCategory,
                                sql, columnNames);

            return getWrappedObject().executeLargeUpdate(sql, columnNames);
         }
         catch (Throwable t)
         {
            throw checkException(t);
         }
      }
      finally
      {
         if (doLocking)
            unlock();
      }
   }
}
